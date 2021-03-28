package com.cping.ricekitchen.service.impl;

import com.cping.ricekitchen.entity.Category;
import com.cping.ricekitchen.mapper.CategoryMapper;
import com.cping.ricekitchen.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
