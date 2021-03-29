package com.cping.ricekitchen.controller;


import com.cping.ricekitchen.common.Result;
import com.cping.ricekitchen.entity.Orderlist;
import com.cping.ricekitchen.mapper.OrderlistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/ricekitchen/orderlist")
public class OrderlistController {

    @Autowired
    OrderlistMapper orderlistMapper;
    @Autowired

    @GetMapping("/getOrderById/{id}")
    public Result getOrderById(@PathVariable("id") Integer id) {
        Orderlist orderlist = orderlistMapper.selectById(id);
        return Result.success(orderlist);
    }

    @GetMapping("/getOrderByCid/{cid}")
    public Result getOrderByCid(@PathVariable("cid") Integer cid) {
        List<Orderlist> orderByCid = orderlistMapper.getOrderByCid(cid);
        return Result.success(orderByCid);
    }

    @PostMapping("/cusAndOrder")


}

