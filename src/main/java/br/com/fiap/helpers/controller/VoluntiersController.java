package br.com.fiap.helpers.controller;

import br.com.fiap.helpers.model.Location;
import br.com.fiap.helpers.model.ProvidedService;
import br.com.fiap.helpers.model.Service;
import br.com.fiap.helpers.model.Voluntier;
import br.com.fiap.helpers.model.dto.ServicesResponseDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import  br.com.fiap.helpers.service.VoluntiersService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class VoluntiersController {

    @Autowired
    private VoluntiersService voluntiersService;

    @ApiOperation("Search Services by Location")
    @PostMapping(value = "/v1/services", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServicesResponseDTO> getServices(@RequestBody Location location) throws Exception {
        ServicesResponseDTO servicesResponseDTO = voluntiersService.getServices(location);
        return ResponseEntity.ok(servicesResponseDTO);
    }

    @ApiOperation("Create Voluntiers")
    @PostMapping(value="/v1/voluntiers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Voluntier> createVoluntier(@RequestBody Voluntier voluntier) throws Exception {
        Voluntier voluntierCreated = voluntiersService.createVoluntier(voluntier);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(voluntierCreated.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
