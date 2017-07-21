package com.zh.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Lait on 2017/7/12.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Warehouse")
public class Warehouse {

    private Long id;

    // 库名
    private String name;

    // 描述
    private String description;

    public Warehouse(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
