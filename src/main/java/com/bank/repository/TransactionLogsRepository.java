package com.bank.repository;

import com.bank.model.TransactionLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransactionLogsRepository extends JpaRepository<TransactionLogs, Integer> {

    // Total number of customers in the last 24 hours for all ATMs
    @Query("SELECT COUNT(DISTINCT t.customerId) FROM TransactionLogs t WHERE t.timestamp >= :startTime")
    long countDistinctCustomersLast24Hours(@Param("startTime") Date startTime);

    // Total number of customers in the last 24 hours for a specific ATM
    @Query("SELECT COUNT(DISTINCT t.customerId) FROM TransactionLogs t WHERE t.atmId = :atmId AND t.timestamp >= :startTime")
    long countDistinctCustomersByAtmLast24Hours(@Param("atmId") Integer atmId, @Param("startTime") Date startTime);

    // Breakdown of transactions by type for all ATMs
    @Query("SELECT t.transactionType, COUNT(t) FROM TransactionLogs t GROUP BY t.transactionType")
    List<Object[]> getTransactionBreakdownByType();

    // Breakdown of transactions by type for a specific ATM
    @Query("SELECT t.transactionType, COUNT(t) FROM TransactionLogs t WHERE t.atmId = :atmId GROUP BY t.transactionType")
    List<Object[]> getTransactionBreakdownByTypeForAtm(@Param("atmId") Integer atmId);

    // Count and list of transactions based on transaction type and status for all ATMs
    @Query("SELECT t FROM TransactionLogs t WHERE t.transactionType = :transactionType AND t.status = :status")
    List<TransactionLogs> findTransactionsByTypeAndStatus(@Param("transactionType") String transactionType,
                                                          @Param("status") String status);

    // Count and list of transactions based on transaction type and status for a specific ATM
    @Query("SELECT t FROM TransactionLogs t WHERE t.atmId = :atmId AND t.transactionType = :transactionType AND t.status = :status")
    List<TransactionLogs> findTransactionsByAtmTypeAndStatus(@Param("atmId") Integer atmId,
                                                             @Param("transactionType") String transactionType,
                                                             @Param("status") String status);
}
