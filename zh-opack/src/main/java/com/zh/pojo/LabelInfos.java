package com.zh.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lait on 2017/7/12.
 */
@Data
@NoArgsConstructor
@ToString
public class LabelInfos {

    private Long id;

    private Long pid;

    // 关联id,可以是资源id/用户id等
    private Long rid;

    // 标签类型 用户相关/产品相关/或其他相关等...
    private String type;

    // 标签值
    private String label;

    // key 标签/系列/其他...
    private String key;

    // 值 标签/系列的值/其他的值...
    private String val;

    // 代码
    private String code;

    // 描述 描述
    private String desc;

}
