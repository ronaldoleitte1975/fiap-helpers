package  br.com.fiap.helpers.service;

import br.com.fiap.helpers.model.Location;
import br.com.fiap.helpers.model.ProvidedService;
import br.com.fiap.helpers.model.Service;
import br.com.fiap.helpers.model.dto.DonorResponseDTO;
import br.com.fiap.helpers.model.dto.ServicesResponseDTO;

import java.util.List;

public interface LocationService {

    public ServicesResponseDTO getNextVoluntiers(Location location);

    public DonorResponseDTO getNextDonors(Location location);

    public  Location create(Location location);
}
