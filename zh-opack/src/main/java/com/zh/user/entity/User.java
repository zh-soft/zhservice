package com.zh.user.entity;

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
@Table(name="user")
public class User {
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

    public User(String name, String contact) {
        this.name = name;
        int len = contact.trim().length();
        if(11 <= len && len <= 14){
            this.cellphone = contact;
        } else {
            this.telephone = contact;
        }
    }

    public User(String name, int age, int sex, String nick, String cellphone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.nick = nick;
        this.cellphone = cellphone;
    }

    public User(String name, int age, int sex, String nick, String cellphone, String idcard) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.nick = nick;
        this.cellphone = cellphone;
        this.idcard = idcard;
    }

    public User(String name, int age, int sex, String nick, String cellphone, String telephone, String idcard, String labels) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.nick = nick;
        this.cellphone = cellphone;
        this.telephone = telephone;
        this.idcard = idcard;
        this.labels = labels;
    }
}
