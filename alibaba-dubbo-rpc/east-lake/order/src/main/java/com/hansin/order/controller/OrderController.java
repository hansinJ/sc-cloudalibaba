package com.hansin.order.controller;

import com.hansin.api.user.model.OrderModel;
import com.hansin.api.user.model.UserModel;
import com.hansin.api.user.service.UserService;
import com.hansin.opticalvallay.model.ApiResult;
import com.hansin.order.service.OrderServiceImpl;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 16:29 2021/2/24
 **/
@RestController
@RequestMapping("v1/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @DubboReference
    UserService userService;

    @GetMapping
    public ApiResult<UserModel> getOrderDetail(@RequestParam(required = false, defaultValue = "1") Integer orderId) {
        OrderModel orderDetail = orderService.getOrderDetail(orderId);
        UserModel userDetail = userService.getUserDetail(62);
        if (userDetail != null) {
            orderDetail.setUserId(userDetail.getUserId());
            orderDetail.setAccount(userDetail.getAccount());
            orderDetail.setNickName(userDetail.getNickName());
        }
        return new ApiResult().setData(orderDetail);
    }

}
