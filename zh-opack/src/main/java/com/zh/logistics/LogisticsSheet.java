package com.zh.logistics;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lait on 2017/7/16.
 */
@Data
@NoArgsConstructor
@ToString
public class LogisticsSheet {

    private Long id;

    // 发货人ID
    private Long consignerId;
    //发货地址
    private String shipAddress;
    //发货人联系电话
    private String consignerPhone;


    // 收货人ID
    private Long consigneeId;
    // 收货地址
    private String consigneeAddress;
    // 收货人联系电话
    private String consigneePhone;

    // 运输人ID
    private Long transporterId;
    private String transporterPhone;
    private String transporterIdcard;
    private String carNumber;
}
