package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User getUserByMassage(@Param("username") String username, @Param("password") String password);
}
