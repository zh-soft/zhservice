package com.zh.adress.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.adress.entity.Adress;
import com.zh.pojo.AdressInfos;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lait on 2017/7/19.
 */
@Service
public class AdressService {

    @Autowired
    private CrudTemplate crudTemplate;

    public AdressInfos getAdress(AdressInfos adressInfos){
        Adress adress = new Adress();
        BeanUtils.copyProperties(adressInfos,adress);
        return null;
    }


    /**
     * 根据id查询地址信息
     * @param id
     * @return
     * @throws Exception
     */
    public AdressInfos getAdressById(Long id) throws Exception {
        Adress adress = crudTemplate.get(Adress.class,id);
        AdressInfos adressInfos = new AdressInfos();
        BeanUtils.copyProperties(adress,adressInfos);
        return adressInfos;
    }



}
