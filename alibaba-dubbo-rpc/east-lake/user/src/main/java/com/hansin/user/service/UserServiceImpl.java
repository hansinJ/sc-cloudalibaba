package com.hansin.user.service;

import com.hansin.api.user.model.UserModel;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Date 18:11 2021/2/20
 **/
@DubboService
public class UserServiceImpl implements com.hansin.api.user.service.UserService {

    @Override
    public UserModel getUserDetail(Integer userId) {
        // 模拟从db查询用户,直接返回结果
        UserModel userModel = new UserModel();
        userModel.setUserId(62);
        userModel.setAccount("hansin2");
        userModel.setNickName("hansin");
        return userModel;
    }

}
