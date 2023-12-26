package com.sfox.service;

import com.sfox.pojo.Categories;
import jdk.jfr.Category;

import java.util.List;

public interface CategoriesService {
    // 新增视频分类
    void add(Categories categories);

    // 视频分类列表查询
    List<Categories> list();

    // 根据 CategoryID 查询分类列表
    Categories findByCategoryID(Integer categoryID);

    // 更新视频分类信息
    void update(Categories categories);

    // 根据 categoryID 删除分类
    void remove(Integer categoryID);
}
