package com.mart.mart.repository;

import com.mart.mart.model.TopUpRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopUpRequestRepository extends JpaRepository<TopUpRequests, Long> {
}
