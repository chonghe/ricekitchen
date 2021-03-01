package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.UserDao;
import com.cping.ricekitchenpos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String flag = "error";
        User user1 = userDao.getUserByMassage(user.getUsername(), user.getPassword());
        HashMap<String, Object> res = new HashMap<>();
        if (user1 != null) {
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user", user);
        return JSON.toJSONString(res);
    }
}
