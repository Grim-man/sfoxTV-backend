package com.sfox.service.impl;

import com.sfox.mapper.CategoriesMapper;
import com.sfox.pojo.Categories;
import com.sfox.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public void add(Categories categories) {
        categoriesMapper.add(categories);
    }

    @Override
    public List<Categories> list() {
        return categoriesMapper.list();
    }

    @Override
    public Categories findByCategoryID(Integer categoryID) {
        return categoriesMapper.findByCategoryID(categoryID);
    }

    @Override
    public void update(Categories categories) {
        categoriesMapper.update(categories);
    }

    @Override
    public void remove(Integer categoryID) {
        categoriesMapper.remove(categoryID);
    }
}
