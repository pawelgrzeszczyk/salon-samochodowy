package com.grzeszczyk.client.api;


import com.grzeszczyk.client.entity.Client;
import com.grzeszczyk.client.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Client save(@RequestBody Client client) {
        Client savedClient = clientService.save(client);
        log.info("Add client {}", savedClient);
        return savedClient;
    }

    @GetMapping("/{id}")
    public Client find(@PathVariable  Long id) {
        return clientService.find(id);
    }

    @RequestMapping("/all_client")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> getUsers() {
        List<Client> clients = clientService.findAll();
        log.info("Retrieve objects {}", clients);
        return clients;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id) {
        clientService.delete(id);
        log.info("Delete client with id {}", id);
        return new ResponseEntity(NO_CONTENT);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Client update(@RequestBody Client client) {
        Client updatedClient = clientService.update(client);
        log.info("Updated client {}", updatedClient);
        return updatedClient;
    }

    @GetMapping("/fill")
    public String fillData(){
        Client paul = new Client();
        paul.setFirstName("Pawel");
        paul.setLastName("Grzeszczyk");
        paul.setAge(26);
        paul.setEmailAdress("paul@paul.com");
        clientService.save(paul);
        return "Created some users.";
    }
}
