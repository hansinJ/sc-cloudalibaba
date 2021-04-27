package com.sl.user.service;

import com.sl.user.model.UserModel;
import org.springframework.stereotype.Service;

/**
 * @Date 18:11 2021/2/20
 **/
@Service
public class UserService {

    public UserModel getUserDetail(Integer userId) {
        // 模拟从db查询用户,直接返回结果
        UserModel userModel = new UserModel();
        userModel.setUserId(62);
        userModel.setAccount("hansin2");
        userModel.setNickName("hansin");
        return userModel;
    }

}
