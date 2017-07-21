package com.zh.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Lait on 2017/7/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="purchaseSheet")
public class PurchaseSheet {

    private Long id;

    // 采购员ID
    private String  pid;
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
}
