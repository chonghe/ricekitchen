package com.cping.ricekitchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cping.ricekitchen.common.Result;
import com.cping.ricekitchen.entity.User;
import com.cping.ricekitchen.entity.vo.LoginVo;
import com.cping.ricekitchen.mapper.UserMapper;
import com.cping.ricekitchen.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
