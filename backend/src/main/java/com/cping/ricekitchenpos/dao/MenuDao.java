package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Menu;
import com.cping.ricekitchenpos.entity.TypeMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {
    Menu getMenuById(@Param("id") Integer id);

    public List<Menu> getOftenGoods();

    public List<Menu> getAllDish(@Param("title") String title, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    public int getDishCounts(@Param("title") String title);

    public int updateState(Integer id, Boolean state);

    public int addDish(Menu user);

    public int deleteDish(int id);

    public Menu getUpdateDish(int id);

    public int editDish(Menu user);

    public List<Menu> getType0Goods();

    public List<Menu> getType1Goods();

    public List<Menu> getType2Goods();

    public List<Menu> getType3Goods();

    public List<Menu> getType4Goods();

    public List<Menu> getType5Goods();


}
