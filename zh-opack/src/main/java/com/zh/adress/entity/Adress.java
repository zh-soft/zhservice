package com.zh.adress.entity;

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
@Table(name="adress")
public class Adress {

    private Long id;

    // 关联id
    private Long rid;

    private String province;

    private String city;

    private String area;

    private String adress;

    private String code;

    private int sort;

    public Adress(String province, String city, String area, String address) {
        this.province = province;
        this.city = city;
        this.area = area;
        this.adress = address;
    }

    public Adress(Long rid, String province, String city, String area, String address) {
        this.rid = rid;
        this.province = province;
        this.city = city;
        this.area = area;
        this.adress = address;
    }

    public Adress(Long rid, String province, String city, String area, String address, String code, int sort) {
        this.rid = rid;
        this.province = province;
        this.city = city;
        this.area = area;
        this.adress = address;
        this.code = code;
        this.sort = sort;
    }

    /**
     * 获取详细地址
     * @return
     */
    public String toAdress(){
        String da = province + "," + city+"," + "," + area + "," + adress;
        return da;
    }


}
