package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Menu;
import com.cping.ricekitchenpos.entity.Order;
import com.cping.ricekitchenpos.entity.OrderDemo;
import com.cping.ricekitchenpos.entity.OrderMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    public List<Order> findOrderAndMenuAll();
    public List<Menu> getAllOrder(@Param("title") String title, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int insertOrder(Order order);
    public int insertOrderMenu(@Param("quantity") int quantity,@Param("total") double total,@Param("list") List orderList);
    public List<OrderDemo> getOrderList();
}
