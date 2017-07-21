package com.zh.pojo;

import lombok.Data;

/**
 * Created by Lait on 2017/7/12.
 */
@Data
public class QrcodeInfos {
    private Long id;
    // 产品序列号
    private String psn;
    // 生产时间
    private String produceTime;
    // 过保时间
    private String guaranteeTime;
    // 跳转网址
    private String url;
    // 微信公共号
    private String wechat;
    // 描述信息多个用逗号分割
    private String description;
}
