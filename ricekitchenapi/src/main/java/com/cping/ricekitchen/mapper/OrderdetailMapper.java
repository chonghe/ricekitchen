package com.cping.ricekitchen.mapper;

import com.cping.ricekitchen.entity.Orderdetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
public interface OrderdetailMapper extends BaseMapper<Orderdetail> {
    List<Orderdetail> getDetailByOid(@Param("oid") Integer oid);
}
