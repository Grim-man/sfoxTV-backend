package com.sfox.controller;

import com.sfox.pojo.Result;
import com.sfox.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
/*
        // 验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return Result.success("用户数据加载中...");
        } catch (Exception e) {
            //验证失败,http响应状态码为 401
            response.setStatus(401);
            return Result.error("未登录...");
        }*/
        return Result.success("用户数据...");

    }
}
