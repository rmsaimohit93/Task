package com.bank.controller;

import com.bank.model.CameraLogs;
import com.bank.service.CameraLogsService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/camera-logs")
public class CameraLogsController {

    private final CameraLogsService cameraLogsService;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public CameraLogsController(CameraLogsService cameraLogsService) {
        this.cameraLogsService = cameraLogsService;
    }

    // 1. Fetch logs by ATM and a specific date
    @GetMapping("/{atmId}/date")
    public List<CameraLogs> getLogsByAtmAndDate(
            @PathVariable Integer atmId,
            @RequestParam("date") String dateStr) throws ParseException {
        Date date = dateFormat.parse(dateStr);
        return cameraLogsService.getLogsByAtmAndDate(atmId, date);
    }

    // 2. Fetch logs by ATM between a date range
    @GetMapping("/{atmId}/date-range")
    public List<CameraLogs> getLogsByAtmAndDateRange(
            @PathVariable Integer atmId,
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr) throws ParseException {
        Date startDate = dateFormat.parse(startDateStr);
        Date endDate = dateFormat.parse(endDateStr);
        return cameraLogsService.getLogsByAtmAndDateRange(atmId, startDate, endDate);
    }

}
