package com.cping.ricekitchenpos;

import com.cping.ricekitchenpos.controller.OrderController;
import com.cping.ricekitchenpos.dao.CustomerDao;
import com.cping.ricekitchenpos.dao.OrderDao;
import com.cping.ricekitchenpos.entity.Menu;
import com.cping.ricekitchenpos.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RicekitchenposApplicationTests {

    @Autowired
    OrderDao orderDao;
    OrderController orderController;

    @Test
    public void test2(){

    }
}