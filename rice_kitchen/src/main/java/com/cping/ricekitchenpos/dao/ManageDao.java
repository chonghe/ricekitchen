package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Manage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageDao {
    public List<Manage> getManage();
}
