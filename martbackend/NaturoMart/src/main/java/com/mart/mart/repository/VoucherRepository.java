package com.mart.mart.repository;

import com.mart.mart.model.Vouchers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Vouchers, Long> {
}
