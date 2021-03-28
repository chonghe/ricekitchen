package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    List<Order> getOrderByCid(@Param("cid") Integer cid);
}
