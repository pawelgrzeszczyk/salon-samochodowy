package com.grzeszczyk.client.api;

import com.grzeszczyk.Car;
import com.grzeszczyk.Client;
import com.grzeszczyk.client.services.ClientService;
import com.grzeszczyk.services.CarService;
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

    @Autowired
    private CarService carService;

    @Autowired
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
    public ResponseEntity delete(@PathVariable Long id) {
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

    @GetMapping("/{id}/buy/{id_car}")
    public String requestClient(@PathVariable Long id,@PathVariable Long id_car){

        Client requestingClient = clientService.find(id);
        Car car = carService.find(id_car);

        if(null != requestingClient){
            if(car.isAvailable() == true){
                List<Car> carList = requestingClient.getCarsList();
                carList.add(car);
                requestingClient.setCarsList(carList);
                car.setClient(requestingClient);
                clientService.update(requestingClient);
                car.setAvailable(false);
                carService.update(car);
                log.info("Added car "+car.getName()+" to client: "+requestingClient.getId());
                return "Congratulations! You bought a car: "+car.toString() ;
            }
            else {
                log.info("This car is not available!");
                return "This car is not available!";
            }
        }
        else {

            log.info("Bad request. Client not found.");
            return "Bad request. Client not found.";
        }
    }

   /* @GetMapping("{id}/bill/{id_dealer}")
    public void requestDealer(@PathVariable Long id,@PathVariable Long id_dealer){
        Client client = clientService.find(id);
        Dealer dealer = dealerController.find(id_dealer);

        dealerController.requestDealer(dealer.getId(),client.getId());

    }*/

    @GetMapping("/fill")
    public String fillData(){
        Client paul = new Client();
        paul.setFirstName("Pawel");
        paul.setLastName("Grzeszczyk");
        paul.setAge(26);
        paul.setEmailAdress("pawel@gmail.com");
        clientService.save(paul);
        return "Created some users...";
    }
}