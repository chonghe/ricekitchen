package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.CustomerDao;
import com.cping.ricekitchenpos.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerDao customerDao;

    @GetMapping("/getCustomerByMobile")
    public String getAllCustomer(Customer customer){
        customer.setMobile("713999");
        List<Customer> byMobile = customerDao.getCustomerByMobile("%"+ customer.getMobile() +"%");
        return JSON.toJSONString(byMobile);
    }
}
