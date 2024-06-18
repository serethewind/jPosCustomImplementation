package com.JPosTMS.repository;

import com.JPosTMS.entities.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDataRepository extends JpaRepository<TransactionData, String> {
}
