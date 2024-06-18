package com.JPosTMS.entities;

import com.JPosTMS.enums.CardType;
import com.JPosTMS.enums.PosEntryMode;
import com.JPosTMS.enums.TransactionStatus;
import com.JPosTMS.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class TransactionData extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;
    private String terminalId;
    private String retrievalReferenceNumber;
    private String cardPan;
    private BigDecimal amount;
    private String outletId;
    @Enumerated(EnumType.STRING)
    private CardType cardType; //cardScheme
    private String issuerBank;
    private String acquirerId;
    private String ptsaHost;//there will be an xml file for every bank
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Instant transmissionDateTime;
    private String stan;
    private String merchantId;
    private String merchantName;
    private String gps;
    private String response;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    @Enumerated(EnumType.STRING)
    private PosEntryMode posEntryMode;
    private String detail; //field for more details
    private String walletId;
    private String settlementId;
}
