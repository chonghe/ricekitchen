package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Menu;
import com.cping.ricekitchenpos.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDetailDao {
    List<OrderDetail> getDetailByOid(@Param("oid") Integer oid);
}
