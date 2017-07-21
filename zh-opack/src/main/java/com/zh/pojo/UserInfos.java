package com.zh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lait on 2017/7/14.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfos {


    private Long id;

    // 真实名称
    private String name;

    private int age;

    private int sex;

    // 昵称
    private String nick;

    // 手机
    private String cellphone;

    // 电话
    private String telephone;

    // 身份证
    private String idcard;

    // 标签信息，多个用逗号
    private String labels;


    /****************** 银行信息 ********************/


    /***************** 账户信息 *********************/
    // 登陆名可以是手机号/自定义账户/第三方关联账户
    private String account;
    // 密码
    private String pwd;

    // 邮箱
    private String email;

    /***************** 地址信息 ********************/
    private String province;

    private String city;

    private String area;

    private String adress;

    private String code;




}
