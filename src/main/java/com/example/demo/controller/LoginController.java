package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.ITokenService;
import com.example.demo.service.IUserInfoService;
import com.example.demo.util.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Resource
    IUserInfoService userInfoService;

    @Resource
    RedisUtil redisUtil;

    @Resource
    ITokenService tokenService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public JSONObject doLogin(UserInfo userInfo, HttpServletRequest request) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        JSONObject jsonObject=new JSONObject();
        wrapper.eq("userName", userInfo.getUserName());
        wrapper.eq("password", userInfo.getPassword());
        List<UserInfo> list = userInfoService.list(wrapper);

        if(list.size() == 0) {
            jsonObject.put("code","400");
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }
            UserInfo userForBase = list.get(0);
            if (!userForBase.getPassword().equals(userInfo.getPassword())){
                jsonObject.put("code","400");
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);

                HttpSession session = request.getSession();

                userForBase.setSessionId(session.getId());
                userForBase.setToken(token);
                session.setAttribute("userId",userForBase.getId());

                redisUtil.set(userForBase.getId().toString(),token);

                jsonObject.put("code","200");
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }

    }



}

