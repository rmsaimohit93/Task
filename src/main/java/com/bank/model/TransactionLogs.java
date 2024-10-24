package com.bank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction_logs")
public class TransactionLogs {

    @Id
    @Column(name = "transaction_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @Column(name = "atm_id", nullable = false)
    private Integer atmId;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    @Column(name = "status", nullable = false)
    private String status;

}
