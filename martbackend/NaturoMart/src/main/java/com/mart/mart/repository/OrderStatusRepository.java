package com.mart.mart.repository;

import com.mart.mart.model.Buyer;
import com.mart.mart.model.OrderStatus;
import com.mart.mart.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    List<OrderStatus> findAllByBuyer(Buyer buyer);

}
