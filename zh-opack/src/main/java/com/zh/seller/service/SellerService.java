package com.zh.seller.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.pojo.ProductInfos;
import com.zh.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lait on 2017/7/11.
 */
@Service
public class SellerService {

    @Autowired
    private CrudTemplate crudTemplate;

    @Autowired
    private ProductService productService;

    /**
     * 进货
     * @param productInfos
     */
    public void stock(ProductInfos productInfos) throws Exception {

        productService.storage(productInfos);



    }


}
