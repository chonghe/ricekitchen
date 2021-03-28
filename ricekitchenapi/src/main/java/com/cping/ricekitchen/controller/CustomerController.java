package com.cping.ricekitchen.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cping.ricekitchen.common.Result;
import com.cping.ricekitchen.entity.Customer;
import com.cping.ricekitchen.entity.User;
import com.cping.ricekitchen.mapper.CustomerMapper;
import com.cping.ricekitchen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/ricekitchen/customer")
public class CustomerController {
    @Autowired
    CustomerMapper customerMapper;

    @GetMapping("/allCustomer")
    public Result getAllCustomer() {
        List<Customer> customers = customerMapper.selectList(null);
        return Result.success(customers);
    }

    @GetMapping("/byMobile/{mobile}")
    public Result getCustomerByMobile(@PathVariable("mobile") String mobile) {
        List<Map<String, Object>> list = customerMapper.selectMaps(new QueryWrapper<Customer>().like("mobile", mobile));
        return Result.success(list);
    }

    @PostMapping("/insertCustomer")
    public Result insertCustomer(@RequestBody Customer customer) {
        int insert = customerMapper.insert(customer);
        if (insert == 0) {
            return Result.fail("Add customer failed");
        }
        return null;
    }


}

