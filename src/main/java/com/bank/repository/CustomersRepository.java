package com.bank.repository;

import com.bank.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    @Query("SELECT COUNT(DISTINCT c.customerId) FROM Customers c WHERE c.createdAt >= :timestamp")
    long countUniqueCustomersByTimestamp(@Param("timestamp") Date timestamp);


}