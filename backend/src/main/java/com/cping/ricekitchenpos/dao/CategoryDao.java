package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Category;
import com.cping.ricekitchenpos.entity.TypeMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    public List<TypeMenu> getType0Goods();
}
