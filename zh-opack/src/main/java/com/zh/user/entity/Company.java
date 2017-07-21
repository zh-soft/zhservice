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
@Table(name="company")
public class Company {
    private Long id;

    // 名称
    private String name;

    // 手机
    private String cellphone;

    // 电话
    private String telephone;

    // 老板
    private String bossName;
}
