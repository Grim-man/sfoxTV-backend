package com.sfox.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

/**
 *  视频种类
 */
@Data
public class Categories {
    @NotNull(groups = Update.class)
    private int CategoryID;
    @NotEmpty(groups = {Update.class, Add.class})
    private String CategoryName;

    /*
        定义分组，以实现对不同分组的校验规则
        如果说某个校验项没有指定分组，默认属于Default分组
        分组之间可以继承，A extends B 那么A中拥有B中所有的校验项
    */

    public interface Add extends Default {

    }

    public interface Update extends Default{

    }
}
