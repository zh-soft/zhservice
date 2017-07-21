package com.zh.buyer.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.pojo.OrderInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lait on 2017/7/12.
 * 卖家服务
 */
@Service
public class BuyService {

    @Autowired
    private CrudTemplate crudTemplate;

    /**
     * 购买
     * @param orderInfos
     */
    public void buy(OrderInfos orderInfos){




    }

}
