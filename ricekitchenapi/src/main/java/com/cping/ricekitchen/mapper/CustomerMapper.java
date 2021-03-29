package com.cping.ricekitchen.mapper;

import com.cping.ricekitchen.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {
    //public List<Customer> getCustomerByMobile(@Param("mobile") String mobile);

    Customer getCustomerById(@Param("id") Integer id);


}
