package com.example.demo.service.impl;

import com.example.demo.entity.UserInfo;
import com.example.demo.mappers.UserInfoMapper;
import com.example.demo.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zp
 * @since 2019-12-20
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectUserByMap(List<UserInfo> userInfos) {
        return  userInfoMapper.selectUserByMap(userInfos);
    }
}
