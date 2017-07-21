package com.zh.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Lait on 2017/7/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="product_warehouse")
public class ProductWarehouse {

    private Long id;

    // 仓库id
    private Long wid;

    // 关联批次
    private int bn;

    // 品牌
    private String brand;

    // 类型
    private String type;

    // 系列
    private String series;

    // 型号
    private String model;

    // 数量
    private int counts;

    // 入库时间
    private Date stime;



    public ProductWarehouse(String brand, String model, int counts) {
        this.brand = brand;
        this.model = model;
        this.counts = counts;
    }

    public ProductWarehouse(String brand, String type, String series, String model, int counts) {
        this.brand = brand;
        this.type = type;
        this.series = series;
        this.model = model;
        this.counts = counts;
    }

    public ProductWarehouse(Long wid, String brand, String type, String series, String model, int counts) {
        this.wid = wid;
        this.brand = brand;
        this.type = type;
        this.series = series;
        this.model = model;
        this.counts = counts;
    }
}
