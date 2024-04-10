package com.sfox;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){

        Map<String,Object> claims = new HashMap<>();
        claims.put("sub",20011020);
        claims.put("name","ChiJiaHang");
        claims.put("iat","1699545600");

        // 生成JWT
        String token = JWT.create()
                .withClaim("user",claims) //添加有效载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24*7)) //添加过期时间（7天）
                .sign(Algorithm.HMAC256("011020/0904cjh+cyr011019/0903understander")); //指定算法，配置密钥
        System.out.println(token);
    }

    /**
     * 如果篡改头部和有效载荷部分，验证失败
     * <br>
     * 修改密钥，验证失败
     * <br>
     * 令牌过期，验证失败
     */

    @Test
    public void testParse(){
        //定义字符串，模拟用户传递的token
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
                ".eyJleHAiOjE3MDAxMjk2NDYsInVzZXIiOnsic3ViIjoyMDAxMTAyMCwibmFtZSI6IkNoaUppYUhhbmciLCJpYXQiOiIxNjk5NTQ1NjAwIn19" +
                ".8_Pb6Hv1rUEl-1uQe8A3atXrY2N6V1PgQjM4axqZcc0";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("011020/0904cjh+cyr011019/0903understander")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
