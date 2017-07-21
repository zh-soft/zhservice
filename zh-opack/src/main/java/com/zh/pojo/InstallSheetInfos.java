package com.zh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Lait on 2017/7/11.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InstallSheetInfos {
    // 关联id
    private Long customerId;
    // 客户类型
    private int customerType;
    // 客户姓名
    private String customerName;
    // 电话
    private String telephone;
    // 手机号
    private String cellphone;
    // 省
    private String province;
    // 市
    private String city;
    // 区
    private String area;
    // 街道等地址信息
    private String adress;
    // 预约时间
    private Date precontractTime;
    // 状态 1保修 2进行中 3完成
    private int status;
    // 产品序列号
    private String psn;
    // 产品型号
    private String model;


    /**
     * 获取详细地址
     * @return
     */
    public String toAdress(){
        String da = province + "," + city+"," + "," + area + "," + adress;
        return da;
    }

}
