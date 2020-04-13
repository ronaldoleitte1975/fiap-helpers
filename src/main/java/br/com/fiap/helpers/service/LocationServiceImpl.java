package br.com.fiap.helpers.service;

import br.com.fiap.helpers.integratrion.LocationIntegration;
import br.com.fiap.helpers.model.*;
import br.com.fiap.helpers.model.dto.DonorResponseDTO;
import br.com.fiap.helpers.model.dto.ServicesResponseDTO;
import br.com.fiap.helpers.repository.DonationRepository;
import br.com.fiap.helpers.repository.DonorRepository;
import br.com.fiap.helpers.repository.LocationRepository;
import br.com.fiap.helpers.repository.VoluntierRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationIntegration locationIntegration;

    @Autowired
    private VoluntierRepository voluntierRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DonorRepository donorRepository;



    @Override
    public ServicesResponseDTO getNextVoluntiers(Location location) {

        List<Voluntier> allVoluntiers = voluntierRepository.findAll();

        List<Voluntier> nextVoluntiers = locationIntegration.getNextVoluntiers(location, allVoluntiers);

        return ServicesResponseDTO.builder().voluntiers(nextVoluntiers).build();


    }

    @Override
    public DonorResponseDTO getNextDonors(Location location) {
        List<Donor> allDonors = donorRepository.findAll();

        List<Donor> nextDonors = locationIntegration.getNextDonors(location, allDonors);

        return DonorResponseDTO.builder().donors(nextDonors).build();


    }

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }
}
