package com.zh.permission.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lait on 2017/7/14.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountRole {

    // 账户id
    private Long aid;
    // 角色id
    private Long rid;
}
