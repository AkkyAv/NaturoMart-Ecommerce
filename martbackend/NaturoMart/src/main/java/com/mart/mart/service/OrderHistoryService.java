package com.mart.mart.service;

import com.mart.mart.model.Buyer;
import com.mart.mart.model.OrderHistory;
import com.mart.mart.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderHistoryService {
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    public OrderHistory newOrderHistory(OrderHistory orderHistory){
        return orderHistoryRepository.save(orderHistory);
    }

    public void deleteAnOrder(Long orderHistoryId){
        Optional<OrderHistory> idHistory = orderHistoryRepository.findById(orderHistoryId);
        if (idHistory.isEmpty()){
            throw new IllegalArgumentException("not found");
        }
        orderHistoryRepository.delete(idHistory.get());
    }

    public void deleteAllHistory(Long buyerId){
        Buyer buyer = new Buyer();
        buyer.setBuyerId(buyerId);

        List<OrderHistory> historyList = orderHistoryRepository.findAllByBuyer(buyer);
        orderHistoryRepository.deleteAll(historyList);
    }
}
