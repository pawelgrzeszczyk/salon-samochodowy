package com.grzeszczyk.dealer.api;


import com.grzeszczyk.Car;
import com.grzeszczyk.Client;
import com.grzeszczyk.Dealer;
import com.grzeszczyk.client.services.ClientService;
import com.grzeszczyk.dealer.services.DealerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/dealer")
public class DealerController {

    private static final Logger log = LoggerFactory.getLogger(DealerController.class);


    @Autowired
    private ClientService clientService;

    @Autowired
    private final DealerService dealerService;

    @Autowired
    public DealerController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Dealer save(@RequestBody Dealer dealer) {
        Dealer savedDealer = dealerService.save(dealer);
        log.info("Add dealer {}", savedDealer);
        return savedDealer;
    }

    @GetMapping("/{id}")
    public Dealer find(@PathVariable  Long id) {
        return dealerService.find(id);
    }

    @RequestMapping("/all_dealer")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Dealer> getDealer() {
        List<Dealer> dealers = dealerService.findAll();
        log.info("Retrieve objects {}", dealers);
        return dealers;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        dealerService.delete(id);
        log.info("Delete dealer with id {}", id);
        return new ResponseEntity(NO_CONTENT);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Dealer update(@RequestBody Dealer dealer) {
        Dealer updatedDealer = dealerService.update(dealer);
        log.info("Updated dealer {}", updatedDealer);
        return updatedDealer;
    }

    @GetMapping("/{id}/getBill/{id_client}")
    public String requestDealer(@PathVariable Long id,@PathVariable Long id_client){

        Client client = clientService.find(id_client);
        Dealer dealer = dealerService.find(id);
        clean(dealer);
        List<Car> carClientList = client.getCarsList();


        for(Car i : carClientList)
            dealer.setQuantity(i.getPrice());

        dealer.setClient(client);
        dealer.setPurchaseOfDate(LocalDate.now());
        client.setDealer(dealer);
        //dealer.setCarsClientList(carClientList);
        clientService.update(client);
        dealerService.update(dealer);


        log.info("dealer id: "+dealer.getId()+" issued the bill for client id: "+client.getId());
        return "the cost of shopping: "+dealer.getQuantity()+" PLN";
    }

    public void clean(Dealer dealer){
        dealer.setQuantity(null);
        dealer.setClient(null);
        dealer.setCarsClientList(null);
    }


    @GetMapping("/fill")
    public String fillData(){
        Dealer janusz = new Dealer();
        janusz.setName("Mirek");
        dealerService.save(janusz);
        return "Created some dealers...";
    }
}
