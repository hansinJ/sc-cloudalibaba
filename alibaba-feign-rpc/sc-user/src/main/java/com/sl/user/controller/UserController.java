package com.sl.user.controller;

import com.sl.common.model.UserModel;
import com.sl.framework.common.model.ApiResult;
import com.sl.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Date 18:10 2021/2/20
 **/
@CrossOrigin
@RestController
@RequestMapping("v1/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Value("${server.port}")
    private String port;

    @GetMapping("{userId}")
    public ApiResult<UserModel> getUserDetail(@PathVariable Integer userId) {
        System.out.println("port = " + port);
        ApiResult apiResult = new ApiResult<>();
        userId = 62;
        return apiResult.setData(userService.getUserDetail(userId));
    }

}
