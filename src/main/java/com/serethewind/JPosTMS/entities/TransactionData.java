package com.serethewind.JPosTMS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class TransactionData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;
}
