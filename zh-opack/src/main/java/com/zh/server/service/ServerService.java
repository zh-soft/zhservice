package com.zh.server.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.dictionary.entity.Labels;
import com.zh.pojo.ServerUserInfos;
import com.zh.adress.entity.Adress;
import com.zh.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lait on 2017/7/12.
 */
@Service
public class ServerService {

    @Autowired
    private CrudTemplate crudTemplate;

    /**
     * 注册
     *
     * @param installerInfos
     * @throws Exception
     */
    public void registe(ServerUserInfos installerInfos) throws Exception {

        /**
         * 增加用户
         */
        User user = new User();
        user.setCellphone(installerInfos.getCellphone());
        user.setTelephone(installerInfos.getTelephone());
        user.setName(installerInfos.getName());
        user.setAge(installerInfos.getAge());
        user.setIdcard(installerInfos.getIdcard());
        user.setSex(installerInfos.getSex());
        user.setNick(installerInfos.getNick());
        crudTemplate.insert(user);


        /**
         * 增加地址
         */
        Adress adress = new Adress(user.getId(), installerInfos.getProvince(), installerInfos.getCity(), installerInfos.getArea(), installerInfos.getAdress());
        crudTemplate.insert(adress);


        /**
         * 增加标签
         */
        List<Labels> labelsList = new ArrayList<>();
        // 用户默认地址label
        labelsList.add(new Labels(user.getId(), installerInfos.getProvince()));
        labelsList.add(new Labels(user.getId(), installerInfos.getCity()));
        labelsList.add(new Labels(user.getId(), installerInfos.getArea()));
        labelsList.add(new Labels(user.getId(), installerInfos.getAdress()));
        // 用户自定义label
        List<String> labels = installerInfos.getLabels();
        for (String label : labels) {
            labelsList.add(new Labels(user.getId(), label));
        }
        crudTemplate.insertBatch(labelsList);
    }
}
