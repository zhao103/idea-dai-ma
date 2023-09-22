package cn.baise.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class Jwt {
    //加密签名
    private static final String QIAN = "@FAFEWA5666565hgj";
    public static  String getToken(Map<String,String> map) {
        Calendar instance = Calendar.getInstance();
        //设置过期时间
        instance.add(Calendar.DATE, 1);
        //创建jwt
        JWTCreator.Builder builder = JWT.create();
        //每一次遍历进行存储
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(QIAN));
        return token;
    }
    //验证
    public static DecodedJWT verif(String token){

        return JWT.require(Algorithm.HMAC256(QIAN)).build().verify(token);
    }
}
