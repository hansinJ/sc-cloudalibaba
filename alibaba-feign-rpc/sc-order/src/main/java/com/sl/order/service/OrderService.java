package com.sl.order.service;

import com.sl.order.extend.OrderModel;
import org.springframework.stereotype.Service;

/**
 * @Date 18:06 2021/2/20
 **/
@Service
public class OrderService {

    public OrderModel getOrderDetail(Integer orderId) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(orderId);
        orderModel.setGoodName("华为Matepro");
        orderModel.setStatus("paid");
        orderModel.setUserId(62);
        orderModel.setPrice(new Double("4999"));
        return orderModel;
    }

}
