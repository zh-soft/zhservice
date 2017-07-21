package com.zh.pojo;

import lombok.Data;

/**
 * Created by Lait on 2017/7/19.
 */
@Data
public class WarehouseInfos {

    // 仓库id
    private Long id;

    // 地址id
    private Long aid;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String area;

    // 详细地址
    private String adress;

    // 区号
    private String code;

    // 库名
    private String name;

    // 描述
    private String description;
}
