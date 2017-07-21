package com.zh.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;

/**
 * Created by Lait on 2017/7/12.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="account")
public class Account {
    private Long id;
    // 关联id 可关联的是一个用户的id,一个企业账户的id等
    private Long rid;
    // 登陆名可以是手机号/自定义账户/第三方关联账户
    private String account;
    // 密码
    private String pwd;


    public Account(Long rid, String account, String pwd) {
        this.rid = rid;
        this.account = account;
        this.pwd = pwd;
    }

    public static void main(String[] args) {
        //Account account = new Account();
    }
}
