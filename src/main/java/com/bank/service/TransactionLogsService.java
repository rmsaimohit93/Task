package com.bank.service;

import com.bank.model.TransactionLogs;
import com.bank.repository.TransactionLogsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionLogsService {

    private final TransactionLogsRepository transactionLogsRepository;

    public TransactionLogsService(TransactionLogsRepository transactionLogsRepository) {
        this.transactionLogsRepository = transactionLogsRepository;
    }

    public long getTotalCustomersLast24Hours() {
        Date startTime = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        return transactionLogsRepository.countDistinctCustomersLast24Hours(startTime);
    }

    public long getTotalCustomersByAtmLast24Hours(Integer atmId) {
        Date startTime = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        return transactionLogsRepository.countDistinctCustomersByAtmLast24Hours(atmId, startTime);
    }

    public List<Object[]> getTransactionBreakdownByType() {
        return transactionLogsRepository.getTransactionBreakdownByType();
    }

    public List<Object[]> getTransactionBreakdownByTypeForAtm(Integer atmId) {
        return transactionLogsRepository.getTransactionBreakdownByTypeForAtm(atmId);
    }

    public List<TransactionLogs> getTransactionsByTypeAndStatus(String transactionType, String status) {
        return transactionLogsRepository.findTransactionsByTypeAndStatus(transactionType, status);
    }

    public List<TransactionLogs> getTransactionsByAtmTypeAndStatus(Integer atmId, String transactionType, String status) {
        return transactionLogsRepository.findTransactionsByAtmTypeAndStatus(atmId, transactionType, status);
    }
}
