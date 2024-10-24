package com.bank.controller;

import com.bank.model.TransactionLogs;
import com.bank.service.TransactionLogsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionLogsController {

    private final TransactionLogsService transactionLogsService;

    public TransactionLogsController(TransactionLogsService transactionLogsService) {
        this.transactionLogsService = transactionLogsService;
    }

    // 1. Total number of customers in the last 24 hours (all ATMs)
    @GetMapping("/customers/last24hours")
    public long getTotalCustomersLast24Hours() {
        return transactionLogsService.getTotalCustomersLast24Hours();
    }

    // 1. Total number of customers in the last 24 hours (specific ATM)
    @GetMapping("/customers/last24hours/{atmId}")
    public long getTotalCustomersByAtmLast24Hours(@PathVariable Integer atmId) {
        return transactionLogsService.getTotalCustomersByAtmLast24Hours(atmId);
    }

    // 2. Breakdown of transactions by type (all ATMs)
    @GetMapping("/breakdown")
    public List<Object[]> getTransactionBreakdownByType() {
        return transactionLogsService.getTransactionBreakdownByType();
    }

    // 2. Breakdown of transactions by type (specific ATM)
    @GetMapping("/breakdown/{atmId}")
    public List<Object[]> getTransactionBreakdownByTypeForAtm(@PathVariable Integer atmId) {
        return transactionLogsService.getTransactionBreakdownByTypeForAtm(atmId);
    }

    // 3. List transactions by type and status (all ATMs)
    @GetMapping("/filter")
    public List<TransactionLogs> getTransactionsByTypeAndStatus(
            @RequestParam String transactionType,
            @RequestParam String status) {
        return transactionLogsService.getTransactionsByTypeAndStatus(transactionType, status);
    }

    // 3. List transactions by type and status (specific ATM)
    @GetMapping("/filter/{atmId}")
    public List<TransactionLogs> getTransactionsByAtmTypeAndStatus(
            @PathVariable Integer atmId,
            @RequestParam String transactionType,
            @RequestParam String status) {
        return transactionLogsService.getTransactionsByAtmTypeAndStatus(atmId, transactionType, status);
    }
}
