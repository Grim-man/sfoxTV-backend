package com.sfox.mapper;

import com.sfox.pojo.Categories;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoriesMapper {
    // 新增视频分类
    @Insert("insert into categories(CategoryName)" +
            " values(#{CategoryName})")
    void add(Categories categories);

    // 查询视频分类
    @Select("select * from categories")
    List<Categories> list();

    // 根据 分类ID 查询
    @Select("select * from categories where CategoryID = #{CategoryID}")
    Categories findByCategoryID(Integer categoryID);

    // 更新视频分类信息
    @Update("update categories set CategoryName = #{CategoryName} where CategoryID = #{CategoryID}")
    void update(Categories categories);

    // 删除
    @Delete("delete from categories where CategoryID = #{CategoryID}")
    void remove(Integer categoryID);
}
