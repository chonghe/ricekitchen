package com.cping.ricekitchenpos;

import com.cping.ricekitchenpos.dao.CustomerDao;
import com.cping.ricekitchenpos.dao.OrderDao;
import com.cping.ricekitchenpos.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RicekitchenposApplicationTests {

    @Autowired
    CustomerDao customerDao;
    OrderDao orderDao;
    @Test
    void contextLoads() {
        //System.out.println(customerDao.getCustomerById(1));
        for ( order:orderDao.getOrderById(1)
             ) {
            System.out.println(order);
        }
    }

}
