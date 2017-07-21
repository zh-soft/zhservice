package com.zh.product.configs;

import org.springframework.context.annotation.Configuration;

import java.text.DecimalFormat;

/**
 * Created by Lait on 2017/7/18.
 */
@Configuration
public class ProductConfig {

    // 格式化总数
    public static DecimalFormat COUNT_FORMAT = new DecimalFormat("00000000");
    // 格式化月份
    public static DecimalFormat MONTH_FORMAT = new DecimalFormat("00");
    // 压保3年
    public static String COMPRESSOR_PT = "3";
    // 批次插入大小
    public static int BATCH_SIZE = 1000;
    // 二维码url
    public static String PRODUCT_URL= "http://zhserver.cn?brand=%s&psn=%s&model=%s&pt=%s&gt=%s&wechat=%s";
    // 服务号
    public static String WECHAT = "众合服务";

}
