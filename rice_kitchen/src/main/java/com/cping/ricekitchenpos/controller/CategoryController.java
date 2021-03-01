package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.CategoryDao;
import com.cping.ricekitchenpos.entity.Category;
import com.cping.ricekitchenpos.entity.TypeMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryDao categoryDao;

    @RequestMapping("/typemenu")
    public String getTypeMenu() {
        List<TypeMenu> type0Goods = categoryDao.getType0Goods();
        return JSON.toJSONString(type0Goods);
    }
}
