package com.cping.ricekitchen.service.impl;

import com.cping.ricekitchen.entity.Customer;
import com.cping.ricekitchen.mapper.CustomerMapper;
import com.cping.ricekitchen.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Override
    public boolean saveOrUpdate(Customer entity) {
        return super.saveOrUpdate(entity);
    }
}
