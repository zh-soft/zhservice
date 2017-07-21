package com.zh.product.controller;

import com.zh.pojo.ProductInfos;
import com.zh.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lait on 2017/7/19.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 创建产品
     * @param productInfos
     */
    public void createProudct(ProductInfos productInfos){
        try {
            productService.produceProduct(productInfos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
