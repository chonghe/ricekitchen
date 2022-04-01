package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Menu;
import com.cping.ricekitchenpos.entity.Order;
import com.cping.ricekitchenpos.entity.OrderMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    public List<Order> findOrderAndMenuAll();
    public List<Menu> getAllOrder(@Param("title") String title, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int insertOrder(Order order);
    public int insertOrderMenu(OrderMenu orderMenu);
}
