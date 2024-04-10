package com.sfox.controller;

import com.sfox.pojo.Result;
import com.sfox.pojo.Users;
import com.sfox.service.UserService;
import com.sfox.utils.JwtUtil;
import com.sfox.utils.Md5Util;
import com.sfox.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{3,16}$") String Username, @Pattern(regexp = "^\\S{6,16}$") String Password, String Email){

        // 查询用户
        Users userName = userService.findByUserName(Username);
        if (userName == null) {
            // 没有被占用，进行注册
            userService.register(Username, Password, Email);
            return Result.success("Register Successfully!");
        } else {
            // 用户名被占用
            return Result.error("用户名已存在！");
        }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{3,16}$") String Username, @Pattern(regexp = "^\\S{6,16}$") String Password){

        // 根据用户名查询用户
        Users loginUser = userService.findByUserName(Username);

        // 判断用户是否存在
        if(loginUser == null){
            return Result.error("用户名错误！");
        }
        // 判断密码是否正确
        // 先转密文，然后判断密文是否相同
        if(loginUser.getPassword().equals(Md5Util.getMD5String(Password))){

            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getUserID());
            claims.put("username",loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            
            return Result.success(token);
        }
        return Result.error("密码错误！");
    }


    /*@GetMapping("/userInfo")
    public Result<Users> userInfo(@RequestHeader(name = "Authorization") String token){
        //根据用户名查询用户信息
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username"); //强制类型转换为 String

        Users user = userService.findByUserName(username);
        return Result.success(user);
    }*/

    @GetMapping("/userInfo")
    public Result<Users> userInfo(){
        //根据用户名查询用户信息
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");

        Users user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated Users users){
        userService.update(users);
        return Result.success("更新完成！");
    }



    @PatchMapping ("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        // 校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        // 以上三个条件缺一不可
        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要参数！");
        }
        // 判断原密码是否正确，可从拦截器处获取
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        Users loginUser = userService.findByUserName(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("原密码输入错误！");
        }
        // 新密码不得与原密码相同
        if(loginUser.getPassword().equals(Md5Util.getMD5String(newPwd))){
            return Result.error("新密码与旧密码不能相同！");
        }
        // 原密码验证通过，进行新密码与确认密码的比对
        if(!rePwd.equals(newPwd)){
            return Result.error("两次填写的新密码不一致！");
        }

        // 根据service完成参数更新
        userService.updatePwd(newPwd);

        return Result.success("密码修改成功！");
    }















}


