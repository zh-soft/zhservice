package com.zh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lait on 2017/7/16.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LogisticsSheetInfos {

    private Long id;

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

    private String transporter;
    private String transporterPhone;
    private String transporterIdcard;
    private String carNumber;


    // 货品取信息
    private String goodsName;
    private String weight;
    private int volume;

    // 费用
    private int cost;
}
