package com.cping.ricekitchen.mapper;

import com.cping.ricekitchen.entity.Customer;
import com.cping.ricekitchen.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    public int updateState(Integer id, Boolean state);





}
