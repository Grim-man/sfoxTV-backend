package com.sfox.controller;

import com.sfox.pojo.Categories;
import com.sfox.pojo.Result;
import com.sfox.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoriesController {

    @Autowired
    private CategoriesService categoryService;

    @PostMapping
    public Result add(@RequestBody @Validated(Categories.Add.class) Categories categories) {
        categoryService.add(categories);
        return Result.success("视频类别添加完成！");
    }

    @GetMapping
    public Result<List<Categories>> list(){
        List<Categories> ifs = categoryService.list();
        return Result.success(ifs);
    }

    @GetMapping("/detail")
    public Result<Categories> detail(Integer CategoryID){
        Categories inf = categoryService.findByCategoryID(CategoryID);
        return Result.success(inf);
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Categories.Update.class) Categories Categories){
        categoryService.update(Categories);
        return Result.success("视频分类更新完成！");
    }

    @DeleteMapping
    public Result remove(Integer CategoryID){
        categoryService.remove(CategoryID);
        return Result.success("删除成功！");
    }
}
