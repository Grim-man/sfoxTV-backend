package com.sfox.service;

import com.sfox.pojo.Users;

import java.sql.Date;

public interface UserService {

    // 根据用户名查询用户
    Users findByUserName(String username);

    // 注册
    void register(String username, String password, String email);


    // 修改密码
    void updatePwd(String newPwd);

    // 修改信息
    void update(Users users);
}
