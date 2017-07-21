package com.zh.server.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="installSheet")
public class RepairSheet {

    private Long id;

    // 创建时间
    private Date createTime;

    // 预约时间
    private Date precontractTime;

    // 唯一序列号
    private String serialNumber;

    // 状态 1保修 2进行中 3完成
    private int status;

    public RepairSheet(Date createTime, Date precontractTime, String serialNumber, int status) {
        this.createTime = createTime;
        this.precontractTime = precontractTime;
        this.status = status;
        this.serialNumber = serialNumber;
    }
}
