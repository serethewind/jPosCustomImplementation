package com.serethewind.JPosTMS.repository;

import com.serethewind.JPosTMS.entities.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDataRepository extends JpaRepository<TransactionData, String> {
}
