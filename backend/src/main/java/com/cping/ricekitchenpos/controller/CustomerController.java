package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.CustomerDao;
import com.cping.ricekitchenpos.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerDao customerDao;

    @GetMapping
    public String getAllCustomer(){
        List<Customer> customers = customerDao.getAllCustomer();
        return JSON.toJSONString(customers);
    }
}
