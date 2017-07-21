package com.zh.warehouse.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.adress.entity.Adress;
import com.zh.pojo.WarehouseInfos;
import com.zh.warehouse.entity.Warehouse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lait on 2017/7/19.
 */
@Service
public class WarehouseService {

    @Autowired
    private CrudTemplate crudTemplate;


    /**
     * 创建仓库
     * @param warehouseInfos
     * @throws Exception
     */
    public void createWarehouse(WarehouseInfos warehouseInfos) throws Exception {
        // 建库
        Warehouse warehouse = new Warehouse();
        BeanUtils.copyProperties(warehouseInfos,warehouse);
        crudTemplate.insert(warehouse);

        // 关联库地址
        Adress adress = new Adress();
        BeanUtils.copyProperties(warehouseInfos,adress);
        adress.setRid(warehouse.getId());
        crudTemplate.insert(adress);
    }


    /**
     * 批量创建仓库
     * @param warehouseInfos
     */
    public void createWarehouses(List<WarehouseInfos> warehouseInfos) throws Exception {
        for(WarehouseInfos wi:warehouseInfos){
            createWarehouse(wi);
        }
    }


}
