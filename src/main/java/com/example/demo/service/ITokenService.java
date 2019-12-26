package com.example.demo.service;

import com.example.demo.entity.UserInfo;

public interface ITokenService {

    public String getToken(UserInfo userInfo);
}
