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
public class Role {

    private Long id;

    // 角色的名称
    private String name;

    // 描述
    private String description;
}
