package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.OrderDao;
import com.cping.ricekitchenpos.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @RequestMapping("/insertorder")
    //public String addOrder(@RequestParam(value="quantity",required=false) Integer quantity,@RequestParam(value="total",required = false) Double total) {
    public String addOrder(@RequestBody Order order){
        int i = orderDao.insertOrderMenu(order.getQuantity(),order.getTotal(),order.getOrderList());
        // order.getOrderList().forEach(item-> System.out.println(item));
        return null;
    }
    @GetMapping("/getorderList")
    public String getOrderListByDate(){
        List<OrderDemo> data = orderDao.getOrderList();
        System.out.println(data);
        return JSON.toJSONString(data);
    }
}
