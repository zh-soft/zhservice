package com.zh.order.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.pojo.OrderInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lait on 2017/7/12.
 * 订单服务
 */
@Service
public class OrderService {

    @Autowired
    private CrudTemplate crudTemplate;

    /**
     * 创建订单
     * @param orderInfos
     */
    public void createOrder(OrderInfos orderInfos){



    }


}
