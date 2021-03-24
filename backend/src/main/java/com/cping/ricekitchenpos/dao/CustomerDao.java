package com.cping.ricekitchenpos.dao;

import com.cping.ricekitchenpos.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {
    public List<Customer> getAllCustomer();

    public Customer getCustomerById(int id);
}
