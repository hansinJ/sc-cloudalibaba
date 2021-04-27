package com.hansin.user.controller;

import com.hansin.api.user.model.UserModel;
import com.hansin.api.user.service.OrderService;
import com.hansin.api.user.service.UserService;
import com.hansin.opticalvallay.model.ApiResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
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
    private UserService userService;
    @Value("${server.port}")
    private String port;
    @DubboReference
    private OrderService orderService;

    @GetMapping("{userId}")
    public ApiResult<UserModel> getUserDetail(@PathVariable Integer userId) {
        System.out.println("port = " + port);
        ApiResult apiResult = new ApiResult<>();
        userId = 62;
        return apiResult.setData(userService.getUserDetail(userId));
    }

    @GetMapping
    public ApiResult<UserModel> getUserInfo() {
        ApiResult apiResult = new ApiResult<>();
        return apiResult.setData(orderService.getOrderInfo());
    }

}
