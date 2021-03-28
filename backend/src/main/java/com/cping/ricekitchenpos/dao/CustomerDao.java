package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {
    public List<Customer> getAllCustomer();

    public List<Customer> getCustomerByMobile(@Param("mobile") String mobile);

    Customer getCustomerById(@Param("id") Integer id);
}
