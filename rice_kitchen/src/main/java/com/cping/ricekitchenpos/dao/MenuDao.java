package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Menu;
import com.cping.ricekitchenpos.entity.TypeMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<Menu> getOftenGoods();

    public List<Menu> getAllUser(@Param("title") String title, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    public int getUserCounts(@Param("title") String title);

    public int updateState(Integer id, Boolean state);

    public int addUser(Menu user);

    public int deleteUser(int id);

    public Menu getUpdateUser(int id);

    public int editUser(Menu user);

    public List<Menu> getType0Goods();

    public List<Menu> getType1Goods();

    public List<Menu> getType2Goods();

    public List<Menu> getType3Goods();

    public List<Menu> getType4Goods();

    public List<Menu> getType5Goods();


}
