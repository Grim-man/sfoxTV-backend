package com.sfox.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应结果 Result
 */

@NoArgsConstructor //无参构造法
@AllArgsConstructor //全参构造法
@Data
public class Result<T> {
    private Integer code; //业务状态码  0-成功  1-失败
    private String message; //提示信息
    private T data; //响应数据

    // 快速返回操作成功 响应结果（带响应数据）
    public static <E> Result<E> success(E data){
        return new Result<>(0, "success", data);
    }

    // 快速返回操作成功响应结果
    public static Result success(){
        return new Result<>(0, "success", null);
    }

    public static Result error(String message){
        return new Result<>(1, message, null);
    }
}
