package com.zh.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Lait on 2017/7/11.
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order")
public class Order {

    private Long id;

    // 卖家id
    private Long sid;

    // 买家id
    private Long bid;

    // 产品唯一序列码
    private String psn;

    // 订单状态 支付完成/未完成
    private int status;

    // 订单创建时间
    private Date createTime;

    public Order(Long sid, Long bid, String psn, int status) {
        this.sid = sid;
        this.bid = bid;
        this.psn = psn;
        this.status = status;
    }

    public Order(Long sid, Long bid, String psn, int status, Date createTime) {
        this.sid = sid;
        this.bid = bid;
        this.psn = psn;
        this.status = status;
        this.createTime = createTime;
    }
}
