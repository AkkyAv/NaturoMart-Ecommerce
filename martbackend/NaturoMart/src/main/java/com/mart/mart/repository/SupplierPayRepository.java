package com.mart.mart.repository;

import com.mart.mart.model.SupplierPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierPayRepository extends JpaRepository<SupplierPay, Long> {
    @Query("SELECT SUM(s.balance) FROM SupplierPay s")
    Double calculateTotalSupplierIncomes();
}
