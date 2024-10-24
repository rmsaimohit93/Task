package com.bank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "camera_logs")
public class CameraLogs {

    @Id
    @Column(name = "camera_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cameraId;

    @Column(name = "atm_id", nullable = false)
    private Integer atmId;

    @Column(name = "recording_type", nullable = false)
    private String recordingType;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Column(name = "timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;


}
