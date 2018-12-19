package com.grzeszczyk.dealer.services;

import com.google.common.collect.Lists;
import com.grzeszczyk.Dealer;
import com.grzeszczyk.dealer.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DealerService {

    @Autowired
    private final DealerRepository dealerRepository;

    @Autowired
    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }


    public Dealer save(Dealer dealer) {
        Dealer savedDealer = dealerRepository.save(dealer);
        return savedDealer;
    }

    public Dealer find(Long id) {
        Optional<Dealer> dealer = dealerRepository.findById(id);
        if (dealer.isPresent()) {
            return dealer.get();
        }
        return null;
    }

    public List<Dealer> findAll() {
        Iterable<Dealer> dealersIterable = dealerRepository.findAll();
        List<Dealer> dealersList = Lists.newArrayList(dealersIterable);
        return dealersList;
    }

    public Dealer update(Dealer dealer) {
        Dealer updatedDealer = dealerRepository.saveAndFlush(dealer);
        return updatedDealer;
    }

    public void delete(Long id) {
        dealerRepository.deleteById(id);
    }


}
