package com.mart.mart.repository;

import com.mart.mart.model.ShoppPay;
import com.mart.mart.model.ShoppPay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppPayRepository extends JpaRepository<ShoppPay, Long> {

    Optional<ShoppPay> findByEmail(String email);

}
