package com.zh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Lait on 2017/7/16.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseSheetInfos {

    private long id;

    // 品牌
    private String brand;
    // 型号
    private String model;
    // 数量
    private String count;
    // 总金额
    private Double amount;
    // 采购时间
    private Date time;


    // 发货人
    private String consigner;
    //发货地址
    private String shipAddress;
    //发货人联系电话
    private String consignerPhone;


    // 收货人
    private String consignee;
    // 收货地址
    private String consigneeAddress;
    // 收货人联系电话
    private String consigneePhone;

    // 采购员
    private String  purchaser;
    private String  purchaserPhone;

}
