package com.example.demo.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.ITokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements ITokenService {
    @Override
    public String getToken(UserInfo userInfo) {
        String token="";
        token= JWT.create().withAudience(userInfo.getId() + "")
                .sign(Algorithm.HMAC256(userInfo.getPassword()));
        return token;

    }
}
