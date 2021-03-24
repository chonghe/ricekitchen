package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    public List<Order> getOrderById(int id);
}
