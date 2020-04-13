package  br.com.fiap.helpers.service;

import br.com.fiap.helpers.model.Location;
import br.com.fiap.helpers.model.ProvidedService;
import br.com.fiap.helpers.model.Service;
import br.com.fiap.helpers.model.Voluntier;
import br.com.fiap.helpers.model.dto.ServicesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import  br.com.fiap.helpers.repository.VoluntierRepository;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class VoluntierServiceImpl implements VoluntiersService {

    @Autowired
    private VoluntierRepository voluntierRepository;

    @Autowired
    private LocationService locationService;

    @Override
    public ServicesResponseDTO getServices(Location location) throws Exception {
        ServicesResponseDTO servicesResponseDTO = locationService.getNextVoluntiers(location);
        return servicesResponseDTO;
    }

    @Override
    public Voluntier createVoluntier(Voluntier voluntier) throws Exception {
       Location location = locationService.create(voluntier.getLocation());
       voluntier.getLocation().setId(location.getId());
        Voluntier voluntierCreated = voluntierRepository.save(voluntier);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(voluntierCreated.getId()).toUri();
        voluntierCreated.setUri(uri.toURL().getPath());
        voluntierCreated.setCreatedDt(LocalDateTime.now());
        for (ProvidedService service : voluntier.getProvidedServices()) {
            service.setVoluntier(voluntier);
        }
        voluntierCreated = voluntierRepository.save(voluntierCreated);
        return voluntierCreated;
    }
}
