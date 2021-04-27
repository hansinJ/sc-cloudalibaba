package com.hansin.order.service;

import com.hansin.api.user.model.OrderModel;
import com.hansin.api.user.service.OrderService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Date 16:30 2021/2/24
 **/
@DubboService
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderModel getOrderDetail(Integer orderId) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(orderId);
        orderModel.setGoodName("华为Matepro");
        orderModel.setStatus("paid");
        orderModel.setUserId(62);
        orderModel.setPrice(new Double("4999"));
        return orderModel;
    }

    @Override
    public Boolean getOrderInfo() {
        System.out.println("true = " + true);
        return true;
    }
}
