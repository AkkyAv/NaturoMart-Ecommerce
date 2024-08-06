package com.mart.mart.service;

import com.mart.mart.model.ShoppPay;
import com.mart.mart.model.TopUpRequests;
import com.mart.mart.repository.ShoppPayRepository;
import com.mart.mart.repository.TopUpRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ShoppPayService {
    @Autowired
    private ShoppPayRepository shoppPayRepository;

    @Autowired
    private TopUpRequestRepository topUpRequestRepository;

    private final PasswordEncoder passwordEncoder;

    public ShoppPayService(ShoppPayRepository shoppPayRepository, PasswordEncoder passwordEncoder) {
        this.shoppPayRepository = shoppPayRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ShoppPay newAccount(ShoppPay shoppPay){
        String email = shoppPay.getEmail();
        Optional<ShoppPay> emailUser = shoppPayRepository.findByEmail(email);
        if (emailUser.isPresent()){
            throw new IllegalArgumentException("email in use");
        }

        String encodedPassword = passwordEncoder.encode(shoppPay.getPassword());
        shoppPay.setPassword(encodedPassword);

        return shoppPayRepository.save(shoppPay);
    }

    public TopUpRequests newTopUpRequest(TopUpRequests topUpRequests){
        return topUpRequestRepository.save(topUpRequests);
    }

}
