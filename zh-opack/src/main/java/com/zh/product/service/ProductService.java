package com.zh.product.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.api.Factory;
import com.zh.api.User;
import com.zh.pojo.ProductInfos;
import com.zh.product.configs.ProductConfig;
import com.zh.product.entity.Product;
import com.zh.product.entity.ProductWarehouse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Lait on 2017/7/12.
 */
@Service
public class ProductService implements Factory.ProductService,User.ProductService{

    @Autowired
    private CrudTemplate crudTemplate;

    @Autowired
    private ProductQrcodeService productQrcodeService;

    @Override
    public void produceProduct(ProductInfos productInfos) throws Exception {
        batchProduceProduct(productInfos);
    }

    @Override
    public ProductInfos getProductInfos(Long id) {
        return null;
    }

    @Override
    public List<ProductInfos> getProductInfos(ProductInfos productInfos) {
        return null;
    }

    /**
     * 单条创建
     * @param productInfos
     * @throws Exception
     */
    public void insertProduct(ProductInfos productInfos) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(productInfos, product);
        crudTemplate.insert(product);
    }

    /**
     * 批量生产产品
     *
     * @param productInfos
     */
    private void batchProduceProduct(ProductInfos productInfos) throws Exception {
        List<Product> products = new ArrayList<>();
        int count = productInfos.getCount();
        /**
         * 序列号
         */
        for (int i = 1; i <= count; i++) {
            Product product = new Product();
            BeanUtils.copyProperties(productInfos, product);
            String psn = String.format(generatePSN(productInfos), ProductConfig.COUNT_FORMAT.format(i));
            product.setPsn(psn);
            products.add(product);
        }

        /**
         * 生产
         */
        if (products.size() > 0) {
            int counts = products.size();
            int batchCount = counts / ProductConfig.BATCH_SIZE;
            int size = 0;
            List<Product> productList;
            for (int i = 0; i < batchCount; i++) {
                size = ProductConfig.BATCH_SIZE * (i + 1);
                productList = products.subList(i * ProductConfig.BATCH_SIZE, size);
                crudTemplate.insertBatch(productList);
            }
            productList = products.subList(size, counts);
            crudTemplate.insertBatch(productList);
        }

        /**
         * 入库
         */
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.setBrand(productInfos.getBrand());
        productWarehouse.setSeries(productInfos.getSeries());
        productWarehouse.setModel(productInfos.getModel());
        productWarehouse.setCounts(productInfos.getCount());
        productWarehouse.setBn(productInfos.getBn());
        productWarehouse.setWid(productInfos.getWid());
        crudTemplate.insert(productWarehouse);


        /**
         * 生成二维码
         */
        productQrcodeService.createProductQrcode(products);

    }


    /**
     * 生产序列号 区号+生产日期+数量+保修时间(整机3年/压缩机5年)059816010000000135
     *
     * @return
     */
    private String generatePSN(ProductInfos productInfos) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(productInfos.getPtime());
        int year = calendar.get(Calendar.YEAR);
        String syear = String.valueOf(year).substring(2);
        String smonth = ProductConfig.MONTH_FORMAT.format(calendar.get(Calendar.MONTH) + 1);
        calendar.setTime(productInfos.getGtime());
        String p2 = String.valueOf(calendar.get(Calendar.YEAR) - year);
        String sn = productInfos.getAreaCode() + syear + smonth + "%s" + ProductConfig.COMPRESSOR_PT + p2;
        return sn;
    }


    /**
     * 关联仓库
     * @param productInfos
     * @throws Exception
     */
    public void storage(ProductInfos productInfos) throws Exception {
        /**
         * 创建产品
         */
        Product product = new Product();
        BeanUtils.copyProperties(productInfos, product);
        crudTemplate.insert(product);

        /**
         * 入产品库
         */
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.setBrand(productInfos.getBrand());
        productWarehouse.setModel(productInfos.getModel());
        productWarehouse.setCounts(productInfos.getCount());
        productWarehouse.setWid(productInfos.getWid());
        crudTemplate.insert(productWarehouse);
    }


    /**
     * 批量关联仓库
     * @param productInfosList
     * @throws Exception
     */
    public void storages(List<ProductInfos> productInfosList) throws Exception {
        List<Product> products = new ArrayList<>();
        for (ProductInfos productInfos : productInfosList) {
            Product product = new Product();
            BeanUtils.copyProperties(productInfos, product);
            products.add(product);
        }
        crudTemplate.insertBatch(products);
    }


    public static void main(String[] args) throws Exception {
        ProductService productService = new ProductService();
        ProductInfos productInfos = new ProductInfos();
        productInfos.setCount(999);
        productInfos.setAreaCode("0589");
        productInfos.setPtime(new Date());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 5);
        productInfos.setGtime(cal.getTime());
        //productService.createProduct(productInfos);
    }
}
