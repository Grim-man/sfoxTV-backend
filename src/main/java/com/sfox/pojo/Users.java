package com.sfox.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *  用户信息
 */
@Data
public class Users {
    @NotNull
    private int UserID;
    private String Username;

    @JsonIgnore // 让Spring-MVC把当前对象转换成json字符串时，忽略掉 Password
    private String Password;

    @Email  //限制为邮箱格式
    private String Email;

    @Pattern(regexp = "^\\S{1,12}$")
    private String Nickname;

    private Date RegistrationDate;

    private LocalDateTime UpdateTime;

}
