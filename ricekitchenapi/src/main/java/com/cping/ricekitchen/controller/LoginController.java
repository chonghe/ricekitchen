package com.cping.ricekitchen.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cping.ricekitchen.common.Result;
import com.cping.ricekitchen.entity.User;
import com.cping.ricekitchen.entity.vo.LoginVo;
import com.cping.ricekitchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ricekitchen")
@CrossOrigin
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVo vo) {
        User user = userService.getOne(new QueryWrapper<User>()
                .eq("username", vo.getUsername())
                .eq("password", vo.getPassword()));
        if (StringUtils.isEmpty(user)) {
            return Result.fail("Username or password does not exist!");
        }
        return Result.success(user);
    }
}
