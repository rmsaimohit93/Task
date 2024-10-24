package com.bank.repository;

import com.bank.model.CameraLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CameraLogsRepository extends JpaRepository<CameraLogs, Integer> {

    // Fetch logs for a specific ATM based on a single date
    @Query("SELECT c FROM CameraLogs c WHERE c.atmId = :atmId AND DATE(c.timestamp) = DATE(:date)")
    List<CameraLogs> findLogsByAtmAndDate(@Param("atmId") Integer atmId, @Param("date") Date date);

    // Fetch logs for a specific ATM between a date range
    @Query("SELECT c FROM CameraLogs c WHERE c.atmId = :atmId AND c.timestamp BETWEEN :startDate AND :endDate")
    List<CameraLogs> findLogsByAtmAndDateRange(
            @Param("atmId") Integer atmId,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);

}
