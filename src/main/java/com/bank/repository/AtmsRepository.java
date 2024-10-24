package com.bank.repository;

import com.bank.model.Atms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AtmsRepository extends JpaRepository<Atms, Integer>, JpaSpecificationExecutor<Atms> {

}