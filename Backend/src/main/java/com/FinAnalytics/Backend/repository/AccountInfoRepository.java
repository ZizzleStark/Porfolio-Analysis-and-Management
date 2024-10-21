package com.FinAnalytics.Backend.repository;

import com.FinAnalytics.Backend.models.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfo, Long> {
}