package com.cping.ricekitchen.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cping.ricekitchen.common.Result;
import com.cping.ricekitchen.entity.Customer;
import com.cping.ricekitchen.entity.User;
import com.cping.ricekitchen.mapper.CustomerMapper;
import com.cping.ricekitchen.service.CustomerService;
import org.apache.ibatis.annotations.Param;
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
@CrossOrigin
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

    @GetMapping("/getCustomerById")
    public Result getCustomerById(@Param("id") Integer id) {
        Customer customerById = customerMapper.getCustomerById(id);
        return Result.success(customerById);
    }

    @PostMapping("/insertCustomer")
    public Result insertCustomer(@RequestBody Customer customer) {
        int insert = customerMapper.insert(customer);
        if (insert == 0) {
            return Result.fail("Add customer failed");
        }
        return null;
    }

    @PutMapping("/updateCustomer")
    public Result updateCustomer(@RequestBody Customer customer) {
        int i = customerMapper.updateById(customer);
        if (i == 0) {
            return Result.fail("Update customer failed");
        }
        return null;
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public Result deleteCustomer(@PathVariable("id") Integer id) {
        int i = customerMapper.deleteById(id);
        if (i == 0) {
            return Result.fail("Delete customer failed");
        }
        return null;
    }
}

