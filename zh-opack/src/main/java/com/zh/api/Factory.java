package com.zh.api;

import com.zh.pojo.ProductInfos;

import java.util.List;

/**
 * Created by Lait on 2017/7/19.
 * 工厂
 */
public interface Factory {

    interface ProductService{
        /**
         * 生产产品
         * @param productInfos
         */
        void produceProduct(ProductInfos productInfos) throws Exception;

        /**
         * 获取产品
         * @param id
         * @return
         */
        ProductInfos getProductInfos(Long id);


        /**
         * 根据条件获取产品信息
         * @param productInfos
         * @return
         */
        List<ProductInfos> getProductInfos(ProductInfos productInfos);

    }


    interface UserService{




    }
}
