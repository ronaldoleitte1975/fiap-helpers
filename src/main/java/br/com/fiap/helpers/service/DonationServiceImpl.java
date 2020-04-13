package br.com.fiap.helpers.service;

import br.com.fiap.helpers.model.Donation;
import br.com.fiap.helpers.model.Donor;
import br.com.fiap.helpers.model.Location;
import br.com.fiap.helpers.model.ProvidedDonation;
import br.com.fiap.helpers.model.dto.DonorResponseDTO;
import br.com.fiap.helpers.repository.DonationRepository;
import br.com.fiap.helpers.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DonationServiceImpl implements DonationsService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private LocationService locationService;

    @Override
    public DonorResponseDTO getDonors(Location location) throws Exception {
        DonorResponseDTO donorResponseDTO = locationService.getNextDonors(location);
        return donorResponseDTO;
    }

    @Override
    public Donor createDonor(Donor donor) throws Exception {
        Location location = locationService.create(donor.getLocation());
        donor.getLocation().setId(location.getId());
        Donor donorCreated = donorRepository.save(donor);
        donorCreated.setCreatedDt(LocalDateTime.now());
        for (ProvidedDonation providedDonation : donor.getProvidedDonations()) {
            providedDonation.setDonor(donorCreated);
        }
        donorCreated = donorRepository.save(donorCreated);
        return donorCreated;
    }

    @Override
    public Donation createDonation(Donation donation) throws Exception {
        return donationRepository.save(donation);
    }
}
