package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.OrderDao;
import com.cping.ricekitchenpos.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderDao orderDao;

//    @GetMapping("/getOrderByCid")
//    public String getOrderById(Customer customer) {
//        customer.setId(1);
//        return JSON.toJSONString(orderDao.findOrderAndMenuAll);
//    }
    @GetMapping("/getAllOrder")
    public String getAllOrder(){
        HashMap<String, Object> data = new HashMap<>();
        List<Order> orders = orderDao.findOrderAndMenuAll();
        if (orders != null) {
            data.put("orders", orders);
            data.put("flag", 200);
        } else {
            data.put("flag", 404);
        }
        return JSON.toJSONString(data);
    }
    @PostMapping("/insertOrder")
    public String addOrder(@RequestBody Order order) {
        int i = orderDao.insertOrder(order);
         // orderDao.insertOrderMenu(orderMenu);
//        for (int j = 0; j < ids.getIds().length; j++) {
//            orderMenu.setOid(order.getId());
//            orderMenu.setMid(ids.getIds()[j]);
//            orderMenuDao.insertOrderMenu(orderMenu);
//        }
        System.out.println(order.getId());
        System.out.println(order.toString());
        return i > 0 ? "success" : "error";

    }
}
