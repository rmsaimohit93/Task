package com.bank.service;

import com.bank.model.CameraLogs;
import com.bank.repository.CameraLogsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CameraLogsService {

    private final CameraLogsRepository cameraLogsRepository;

    public CameraLogsService(CameraLogsRepository cameraLogsRepository) {
        this.cameraLogsRepository = cameraLogsRepository;
    }

    public List<CameraLogs> getLogsByAtmAndDate(Integer atmId, Date date) {
        return cameraLogsRepository.findLogsByAtmAndDate(atmId, date);
    }

    public List<CameraLogs> getLogsByAtmAndDateRange(Integer atmId, Date startDate, Date endDate) {
        return cameraLogsRepository.findLogsByAtmAndDateRange(atmId, startDate, endDate);
    }

}
