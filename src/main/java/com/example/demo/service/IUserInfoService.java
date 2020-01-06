package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zp
 * @since 2019-12-20
 */
public interface IUserInfoService extends IService<UserInfo> {

    List<UserInfo> selectUserByMap(List<UserInfo> userInfos);

}
