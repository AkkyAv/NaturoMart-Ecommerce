package com.mart.mart.repository;

import com.mart.mart.model.Buyer;
import com.mart.mart.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    List<OrderHistory> findAllByBuyer(Buyer buyer);
}
