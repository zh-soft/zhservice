package com.zh.qrcode.entity;

import com.tasfe.framework.crud.api.annotation.Storager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;

/**
 * Created by Lait on 2017/7/11.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="qrcode")
@Storager
// http://zhserver.cn?brand=%s&psn=%s&model=%s&pt=%s&gt=%s&wechat=%s;
public class Qrcode {
    private Long id;
    // 跳转网址
    private String url;
    // 品牌
    private String brand;
    // 产品序列号
    private String psn;
    // 型号 model
    private String model;
    // 生产时间produceTime
    private String pt;
    // 过保时间guaranteeTime
    private String gt;
    // 微信公共号
    private String wechat;
    // 描述信息多个用逗号分割
    private String des;

    public Qrcode(String url, String brand, String psn, String model, String pt, String gt, String wechat, String des) {
        this.url = url;
        this.brand = brand;
        this.psn = psn;
        this.model = model;
        this.pt = pt;
        this.gt = gt;
        this.des = des;
        this.wechat = wechat;
    }

    public Qrcode(String url, String brand, String psn, String model, String pt, String gt, String wechat) {
        this.url = url;
        this.brand = brand;
        this.psn = psn;
        this.model = model;
        this.pt = pt;
        this.gt = gt;
        this.wechat = wechat;
    }
}
