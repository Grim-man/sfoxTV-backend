package com.sfox.mapper;

import com.sfox.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;

@Mapper
public interface UserMapper {
    // 根据用户名查询
    @Select("select * from Users where Username=#{username}")
    Users findByUserName(String username);


    // 添加/注册
    @Insert("insert into Users(Username,Password,Email,RegistrationDate)" +
            "values(#{username},#{md5String},#{email},now())")
    void add(String username, String md5String, String email);

    // 修改密码
    @Update("update Users set Password=#{md5String},UpdateTime=now() where UserID=#{id}")
    void updatePwd(String md5String, Integer id);

    @Update("update Users set Nickname=#{Nickname},Email=#{Email},UpdateTime=#{UpdateTime} where UserID=#{UserID}")
    void update(Users users);
}
