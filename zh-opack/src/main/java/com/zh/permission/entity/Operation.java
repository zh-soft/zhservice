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
public class Operation {

    private Long id;

    // 角色id
    private Long rid;

    private String name;
    private String code;
    private String description;

}
