package com.mart.mart.repository;

import com.mart.mart.model.Buyer;
import com.mart.mart.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> findAllByBuyer(Buyer buyer);
}
