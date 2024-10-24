package com.bank.service;

import com.bank.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class CustomerService {

    @Autowired
    private CustomersRepository customerRepository;


    public long getUniqueCustomersInLast24Hours() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -24);
        Date timestamp = calendar.getTime();

        return customerRepository.countUniqueCustomersByTimestamp(timestamp);
    }

}

