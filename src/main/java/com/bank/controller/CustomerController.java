package com.bank.controller;

import com.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atm")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/count")
    public long getTotalCustomersInLast24Hours() {
        return customerService.getUniqueCustomersInLast24Hours();
    }


}

