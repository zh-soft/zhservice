package com.zh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lait on 2017/7/12.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerUserInfos {

    private Long id;

    // 真实名称
    private String name;

    // 身份证
    private String idcard;

    // 年龄
    private int age;

    // 性别
    private int sex;

    // 昵称
    private String nick;

    // 标签
    private List<String> labels = new ArrayList<>();



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




}
