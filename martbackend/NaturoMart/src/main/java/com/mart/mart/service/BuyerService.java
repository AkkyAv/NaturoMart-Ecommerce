package com.mart.mart.service;

import com.mart.mart.model.Buyer;
import com.mart.mart.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public Buyer saveBuyer(Buyer buyer){
        return buyerRepository.save(buyer);
    }
}
