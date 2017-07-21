package com.zh.dictionary.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;

/**
 * Created by Lait on 2017/7/16.
 *
 * ------------------------------
 * id    type    key    value
 * 1     user    labels installer
 * 2     user    labels repairer
 * 3     product series 日系列
 * 4     product series 月系列
 */

/**
 * -----------------------------------------------------------------------------------------------------------------------------
 * id               pid            type                key                 value               code                description
 * 1                null           user                labels              installer           1                   安装人员
 * 2                null           product             series              日系列               1                   产品系类
 * 3                null           address             province            安徽省               1                   省份
 * 4                3              address             city                滁州市               0550                市
 * 5                4              address             area                琅玡区               0                   区
 * 6                null
 */
@Data
@NoArgsConstructor
@ToString
@Table(name="labels")
public class Labels {
    private Long id;

    private Long pid=0L;

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


    public Labels(Long rid, String label) {
        this.rid = rid;
        this.label = label;
    }

    public Labels(Long id, Long rid, String label) {
        this.id = id;
        this.rid = rid;
        this.label = label;
    }
}
