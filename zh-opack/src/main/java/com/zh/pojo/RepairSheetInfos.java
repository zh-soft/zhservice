package com.zh.pojo;

import com.zh.qrcode.entity.Qrcode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Lait on 2017/7/11.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RepairSheetInfos {

    private Long id;

    // 客户姓名
    private String customerName;
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

    // 二维码
    private Qrcode qrcode;
}
