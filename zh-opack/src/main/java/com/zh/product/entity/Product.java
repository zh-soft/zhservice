package com.zh.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Lait on 2017/7/11.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="product")
public class Product {

    private Long id;

    // 批次
    private int bn;

    // 品牌
    private String brand;

    // 类型
    private String type;

    // 系列型号 家用/商用
    private String series;

    // 产品序列号 区号+生产日期+数量+保修时间(整机3年/压缩机5年)059816010000000135
    private String psn;

    // 编号
    private String number;

    // SKU码
    private String sku;

    // 产品型号
    private String model;

    // 描述
    private String descr;

    // 生产日期
    private Date ptime;

    // 保期
    private Date gtime;

}
