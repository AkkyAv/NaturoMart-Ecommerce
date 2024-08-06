package com.mart.mart.service;


import com.mart.mart.model.SupplierPay;
import com.mart.mart.repository.SupplierPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SupplierPayService {

    @Autowired
    private SupplierPayRepository supplierPayRepository;

    public SupplierPay newAccount(SupplierPay supplierPay){
        return supplierPayRepository.save(supplierPay);
    }

}
