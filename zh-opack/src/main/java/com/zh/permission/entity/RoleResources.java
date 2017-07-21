package com.zh.permission.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lait on 2017/7/17.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleResources {

    private Long id;

    private Long roleId;

    private Long resId;
}
