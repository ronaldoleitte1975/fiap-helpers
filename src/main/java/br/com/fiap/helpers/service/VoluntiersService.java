package  br.com.fiap.helpers.service;

import br.com.fiap.helpers.model.Location;
import br.com.fiap.helpers.model.ProvidedService;
import br.com.fiap.helpers.model.Service;
import br.com.fiap.helpers.model.Voluntier;
import br.com.fiap.helpers.model.dto.ServicesResponseDTO;

import java.util.List;

public interface VoluntiersService {

    public ServicesResponseDTO getServices(Location location) throws Exception;

    public Voluntier createVoluntier(Voluntier voluntier) throws Exception;

}
