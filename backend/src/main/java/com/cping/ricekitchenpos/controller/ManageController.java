package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.ManageDao;
import com.cping.ricekitchenpos.entity.Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ManageController {
    @Autowired
    ManageDao manageDao;

    @RequestMapping("/manage")
    public String getAllNav(){
        HashMap<String, Object> data = new HashMap<>();
        List<Manage> manages = manageDao.getManage();
        if (manages != null) {
            data.put("manages", manages);
            data.put("flag", 200);
        } else {
            data.put("flag", 404);
        }
        return JSON.toJSONString(data);
    }
}
