package com.cping.ricekitchenpos;

import com.cping.ricekitchenpos.dao.CustomerDao;
import com.cping.ricekitchenpos.dao.OrderDao;
import com.cping.ricekitchenpos.dao.OrderDetailDao;
import com.cping.ricekitchenpos.entity.Menu;
import com.cping.ricekitchenpos.entity.Order;
import com.cping.ricekitchenpos.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RicekitchenposApplicationTests {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderDetailDao detailDao;
    @Test
    void contextLoads() {
        /*Order order = orderDao.getOrderById(1);
        for (OrderDetail detail: order.getOrderDetails()
             ) {
            System.out.println(detail);
        }*/
        //System.out.println(orderDao.getOrderById(1));
        //System.out.println(detailDao.getDetailByOid(1));
        //System.out.println(customerDao.getCustomerById(1));
        /*for ( Order order:orderDao.getOrderById(1)
             ) {
            System.out.println(order);
        }*/
        /*for (OrderDetail detail :
                detailDao.getDetailByOid(1)) {
            System.out.println(detail);
        }*/
        System.out.println(customerDao.getCustomerByMobile("%7139998888%"));
    }

}
