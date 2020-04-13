package  br.com.fiap.helpers.service;

import br.com.fiap.helpers.model.Donation;
import br.com.fiap.helpers.model.Donor;
import br.com.fiap.helpers.model.Location;
import br.com.fiap.helpers.model.dto.DonorResponseDTO;

import java.util.List;

public interface DonationsService {

    public DonorResponseDTO getDonors(Location location) throws Exception;

    public Donor createDonor(Donor donor) throws Exception;

    public Donation createDonation(Donation donation) throws Exception;

}
