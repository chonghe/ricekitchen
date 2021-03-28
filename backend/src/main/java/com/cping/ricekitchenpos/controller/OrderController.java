package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.OrderDao;
import com.cping.ricekitchenpos.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderDao orderDao;

    @GetMapping("/getOrderByCid")
    public String getOrderById(Customer customer) {
        customer.setId(1);
        return JSON.toJSONString(orderDao.getOrderByCid(customer.getId()));
    }
}
