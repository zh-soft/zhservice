package com.zh.user.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.pojo.UserInfos;
import com.zh.user.entity.Account;
import com.zh.adress.entity.Adress;
import com.zh.user.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Created by Lait on 2017/7/14.
 */
public class UserService {

    @Autowired
    private CrudTemplate crudTemplate;

    public void regist(UserInfos userInfos) throws Exception {

        User user = new User();
        BeanUtils.copyProperties(user,userInfos);
        crudTemplate.insert(user);

        Adress adress = new Adress();
        BeanUtils.copyProperties(adress,userInfos);
        adress.setRid(user.getId());
        crudTemplate.insert(adress);


        Account account = new Account();
        BeanUtils.copyProperties(account,userInfos);
        account.setRid(user.getId());
        crudTemplate.insert(account);

    }


    public void updateAdress(UserInfos userInfos) throws Exception {

        Adress adress = new Adress();
        BeanUtils.copyProperties(adress,userInfos);
        adress.setRid(userInfos.getId());
        crudTemplate.update(adress);
    }

    // 分裤分表
    public static void main(String[] args) {
        // 每个数据库的容量
        int total = 8000000;
        // 不停变化sv的值

        int sv =54495;

        for(int i=16000000;i<32000000;i++){
            sv = i;
            System.out.println("======"+sv);
            // 规划集群中数据库的数量(一主,三从)
            int dbCount = 4;
            // 规划数据表的数据量,算法不受库的限制
            int tbCount = 2;
            // 倍增因子
            long divisor = Math.round(sv/total);
            // 系数
            long coefficient = sv%total;
            // 库
            long ds = coefficient%dbCount+divisor*dbCount;
            // 表
            long tb =coefficient%tbCount;
            System.out.println("db_" + ds + ".tb_" + tb);
        }

    }




}
