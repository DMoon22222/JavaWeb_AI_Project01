package com.scut;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTest {
    /*
     * 测试生成JWT令牌
     */
    @Test
    public void testGenrateJWT(){
        Map<String, Object> dataMap=new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","admin");
        String compact = Jwts.builder().signWith(SignatureAlgorithm.HS256, "c2N1dAo=")//指定加密算法，密钥
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 3000))//设置过期时间（此处为2小时）
                .compact();//生成令牌
        System.out.println(compact);
    }
    /*
     * 测试解析JWT令牌
     */
    @Test
    public void testParseJWT(){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc3NTAzNDU2OX0.IQ-CZPGPGtDezl7C6r5SNJsYyFZjpSzizRBtE-qmj88";
        Claims claims=Jwts.parser()
                .setSigningKey("c2N1dAo=")//指定密钥
                .parseClaimsJws(token)//解析令牌
                .getBody();//获取自定义信息
        System.out.println(claims);

    }


}
