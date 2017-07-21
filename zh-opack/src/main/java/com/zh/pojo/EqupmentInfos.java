package com.zh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Lait on 2017/7/12.
 * 设备信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EqupmentInfos {

    private Long id;

    private String brand;

    private String sn;
}
