package com.bank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "atms")
public class Atms {

    @Id
    @Column(name = "atm_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer atmId;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "model")
    private String model;

    @Column(name = "installation_date")
    private Date installationDate;

    @Column(name = "last_service_date")
    private Date lastServiceDate;

}
