package com.example.demo.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zp
 * @since 2019-12-20
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserInfo> selectUserByMap (List<UserInfo> userInfos);

}
