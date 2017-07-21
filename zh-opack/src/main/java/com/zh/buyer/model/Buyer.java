package com.zh.buyer.model;

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
public class Buyer {
    private Long id;

    // 用户id
    private Long uid;

    // 用户0/公司1
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




    public Buyer(int customerType, String customerName, String cellphone, String telephone, String detailAdress) {
    }
}
