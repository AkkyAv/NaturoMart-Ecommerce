package com.mart.mart.service;


import com.mart.mart.model.OrderStatus;
import com.mart.mart.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public OrderStatus newStatus(OrderStatus orderStatus){
        return orderStatusRepository.save(orderStatus);
    }

    public List<OrderStatus> allStatusOrder(){
        return orderStatusRepository.findAll();
    }

    public void deleteStatus(Long orderStatusId) {
        Optional<OrderStatus> idOrder = orderStatusRepository.findById(orderStatusId);
        idOrder.ifPresent(orderStatus -> orderStatusRepository.delete(orderStatus));
    }

}
