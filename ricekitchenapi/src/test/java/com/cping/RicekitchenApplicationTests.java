package com.cping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cping.ricekitchen.entity.Customer;
import com.cping.ricekitchen.mapper.CustomerMapper;
import com.cping.ricekitchen.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@MapperScan("com.cping.ricekitchen.mapper")
@SpringBootTest
class RicekitchenApplicationTests {

    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CustomerServiceImpl customerService;
    @Test
    void contextLoads() {
        List<Customer> customers = customerMapper.selectList(null);
        customers.forEach(System.out::println);
    }

    @Test
    void customerUpdate(){
        Customer customer = new Customer();
        customer.setId(4);
        customer.setName("cping");
        customer.setMobile("7139996666");
        customer.setAddress("5815 Gulfton");
        int i = customerMapper.updateById(customer);
        System.out.println(i);
    }

    @Test
    void customerInsertOrUpdate(){
        Customer customer = new Customer();
        customer.setName("zhangsan");
        customer.setMobile("7139996810");
        customer.setAddress("2111 Holly Hall");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("mobile",customer.getMobile());
        Integer integer = customerMapper.selectCount(wrapper);
        //System.out.println(integer);
        if (integer == 0) {
            customerMapper.insert(customer);
        } else {
            customerMapper.updateById(customer);
        }

    }

    @Test
    void customerDelete(){
        HashMap<String, Object> customer = new HashMap<>();
        customer.put("mobile","7139996808");
        customerMapper.deleteByMap(customer);
    }

    /*@Test
    void cusSaveOrUpdate() {
        Customer customer = new Customer();
        customer.setName("zhangsan");
        customer.setMobile("7139996810");
        customer.setAddress("2111 Holly Hall");
        boolean b = customerService.saveOrUpdate(customer);
        System.out.println(b);
    }*/

}
