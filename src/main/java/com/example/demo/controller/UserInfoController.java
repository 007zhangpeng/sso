package com.example.demo.controller;


import com.example.demo.configuration.PassToken;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.IUserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zp
 * @since 2019-12-19
 */

@RestController
@RequestMapping("/userInfo")

public class UserInfoController {

    @Resource
    private IUserInfoService userInfoService;


    @ApiOperation(value="获取用户详细信息", notes="获取用户详细信息")
    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    @PassToken
    public List<UserInfo> selectUser(){
        return  userInfoService.list();
    }

    @ApiOperation(value="添加用户", notes="添加用户")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean add(UserInfo userInfo){
        return  userInfoService.save(userInfo);
    }

    @ApiOperation(value="删除用户", notes="删除用户")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public boolean deleteById(@PathVariable Integer id){
        return  userInfoService.removeById(id);
    }


}
