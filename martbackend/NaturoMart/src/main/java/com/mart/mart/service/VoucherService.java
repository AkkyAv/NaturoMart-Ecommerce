package com.mart.mart.service;

import com.mart.mart.model.Buyer;
import com.mart.mart.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

//    public Buyer newVoucher
}
