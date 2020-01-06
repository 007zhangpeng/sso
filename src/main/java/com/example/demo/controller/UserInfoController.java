package com.example.demo.controller;


import com.example.demo.configuration.PassToken;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.IUserInfoService;
import com.example.demo.util.QRCodeUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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


    @ApiOperation(value="获取用户详细信息", notes="获取用户详细信息")
    @RequestMapping(value = "/selectUserByMap",method = RequestMethod.GET)
    @PassToken
    public List<UserInfo> selectUserByMap(){


        List<UserInfo> userInfos = new ArrayList<>();
        UserInfo u1 = new UserInfo();
        UserInfo u2 = new UserInfo();
        UserInfo u3 = new UserInfo();
        u1.setId(2);
        u2.setId(6);
        u3.setId(8);
        u1.setName("威威");
        u2.setName("啦啦");
        u3.setName("www");
        userInfos.add(u1);userInfos.add(u2);userInfos.add(u3);
        return  userInfoService.selectUserByMap(userInfos);
    }


    public static void main(String[] args) throws Exception {
// 存放在二维码中的内容
        String path = "C:\\Users\\Administrator\\Desktop\\123.jpg";
        System.out.println(path);
        String text = "https://www.baidu.com";
        // 嵌入二维码的图片路径
        // 生成的二维码的路径及名称
        String destPath = "F:/test.jpg";
        //生成二维码
        QRCodeUtil.encode(text, path, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);



    }

}
