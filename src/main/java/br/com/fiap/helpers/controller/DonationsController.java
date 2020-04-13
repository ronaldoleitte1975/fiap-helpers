package br.com.fiap.helpers.controller;

import br.com.fiap.helpers.model.Donation;
import br.com.fiap.helpers.model.Donor;
import br.com.fiap.helpers.model.Location;
import br.com.fiap.helpers.model.Person;
import br.com.fiap.helpers.model.dto.DonorResponseDTO;
import br.com.fiap.helpers.service.DonationsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DonationsController {

    @Autowired
    private DonationsService donationsService;

    @ApiOperation("Search Donors by Location")
    @PostMapping(value = "/v1/donors", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DonorResponseDTO> getDonors(@RequestBody Location location) throws Exception {

        DonorResponseDTO donors = donationsService.getDonors(location);
        return ResponseEntity.ok(donors);
    }

    @ApiOperation("Create Donor")
    @PostMapping(value = "/v1/donor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDonor(@RequestBody Donor donor) throws Exception {
        Donor donorCreated =  donationsService.createDonor(donor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(donorCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @ApiOperation("Create Donation")
    @PostMapping(value = "/v1/donation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDonation(@RequestBody Donation donation) throws Exception {
        Donation donationCreated =  donationsService.createDonation(donation);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(donationCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
