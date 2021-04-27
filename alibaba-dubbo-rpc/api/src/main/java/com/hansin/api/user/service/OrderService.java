package com.hansin.api.user.service;

import com.hansin.api.user.model.OrderModel;

/**
 * @Date 17:16 2021/2/26
 **/
public interface OrderService {

    OrderModel getOrderDetail(Integer userId);

    Boolean getOrderInfo();
}
