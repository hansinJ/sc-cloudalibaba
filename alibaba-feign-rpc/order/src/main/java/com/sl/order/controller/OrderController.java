package com.sl.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sl.common.model.UserModel;
import com.sl.framework.common.model.ApiResult;
import com.sl.order.extend.OrderModel;
import com.sl.order.feign.UserServiceFeign;
import com.sl.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Hans
 * @Date 13:59 2020/5/6
 **/
@RestController
@RequestMapping("v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping
    public ApiResult<UserModel> getOrderDetail(@RequestParam(required = false, defaultValue = "1") Integer orderId) {
        OrderModel orderDetail = orderService.getOrderDetail(orderId);
        ApiResult<UserModel> userApiResult = userServiceFeign.getUserDetail(orderDetail.getUserId());
        if (userApiResult.getCode() != 0) {
            return userApiResult;
        }
        orderDetail.setNickName(userApiResult.getData().getNickName());
        orderDetail.setAccount(userApiResult.getData().getAccount());
        return new ApiResult().setData(orderDetail);
    }

    @SentinelResource("list")
    @GetMapping("list")
    public String getOrders() {
        System.out.println("////////////");
        return "success";
    }
}
