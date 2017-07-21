package com.zh.product.service;

import com.google.zxing.WriterException;
import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.product.configs.ProductConfig;
import com.zh.product.entity.Product;
import com.zh.qrcode.service.QrcodeService;
import com.zh.qrcode.entity.Qrcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lait on 2017/7/18.
 */
@Service
public class ProductQrcodeService {

    @Autowired
    private CrudTemplate crudTemplate;

    @Autowired
    private QrcodeService qrcodeService;

    /**
     * 根据产品ids 生成二维码
     * @param pids
     * @throws Exception
     */
    public void generateProductQrcode(List<Long> pids) throws Exception {
        int counts = pids.size();
        int batchCount = counts / ProductConfig.BATCH_SIZE;
        int size = 0;
        List<Long> ids;
        List<Product> products;
        for (int i = 0; i < batchCount; i++) {
            size = ProductConfig.BATCH_SIZE * (i + 1);
            ids = pids.subList(i * ProductConfig.BATCH_SIZE, size);
            products = crudTemplate.gets(Product.class, (Long[])ids.toArray());
            createProductQrcode(products);
        }
        ids = pids.subList(size,counts);
        products = crudTemplate.gets(Product.class, (Long[])ids.toArray());
        createProductQrcode(products);
    }

    /**
     * 根据配置生产二维码
     * @param products
     */
    public void createProductQrcode(List<Product> products){
        List<Qrcode> qrcodeList = new ArrayList<>();
        products.stream().forEach(product -> {
            Qrcode qrcode = new Qrcode(ProductConfig.PRODUCT_URL,
                    product.getBrand(),
                    product.getPsn(),
                    product.getModel(),
                    String.valueOf(product.getPtime()),
                    String.valueOf(product.getGtime().getTime()),
                    ProductConfig.WECHAT);
            qrcodeList.add(qrcode);
            String _url = String.format(ProductConfig.PRODUCT_URL,product.getBrand(),product.getPsn(),product.getModel(),product.getPtime(),product.getGtime(),ProductConfig.WECHAT);
            try {
                qrcodeService.generateQRCode(_url);
            } catch (WriterException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * 批量插入产品二维码
     * @param qrcodeList
     * @throws Exception
     */
    public void batchInsertProductQrcode(List<Qrcode> qrcodeList) throws Exception {
        crudTemplate.insertBatch(qrcodeList);
        /*if (qrcodeList.size() > 0) {
            int counts = qrcodeList.size();
            int batchCount = counts / ProductConfig.BATCH_SIZE;
            int size = 0;
            List<Qrcode> qrcodes;
            for (int i = 0; i < batchCount; i++) {
                size = ProductConfig.BATCH_SIZE * (i + 1);
                qrcodes = qrcodeList.subList(i * ProductConfig.BATCH_SIZE, size);
                crudTemplate.insertBatch(qrcodes);
            }
            qrcodes = qrcodeList.subList(size, counts);
            crudTemplate.insertBatch(qrcodes);
        }*/
    }

    /**
     * 单挑出入qrcode
     * @param qrcode
     * @throws Exception
     */
    public void insertProductQrcode(Qrcode qrcode) throws Exception {
        crudTemplate.insert(qrcode);
    }
}
