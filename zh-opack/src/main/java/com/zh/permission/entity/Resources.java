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
public class Resources {

    private Long id;


    // 资源的类型
    private String type;

    // 资源名称
    private String name;

    // 资源的值
    private String value;

    // 资源的描述
    private String description;

    // 资源的状态
    private int status;

}
