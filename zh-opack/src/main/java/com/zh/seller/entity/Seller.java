package com.zh.seller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lait on 2017/7/11.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seller {
    private Long id;

    // 用户ID
    private Long uid;


    /**
     * 个人或公司
     */
    private int type;
    // 卖家名称/公司名称或个人名称 如果没有则从用户处同步，可以没有
    private String name;
    // 手机
    private String cellphone;
    // 电话
    private String telephone;
    /**
     * 地址信息
     */
    private String province;

    private String city;

    private String area;

    private String address;
}
