package com.zh.buyer.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.adress.entity.Adress;
import com.zh.dictionary.entity.Labels;
import com.zh.pojo.Constants;
import com.zh.pojo.InstallSheetInfos;
import com.zh.pojo.LabelInfos;
import com.zh.server.entity.InstallSheet;
import com.zh.user.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lait on 2017/7/11.
 * 安装服务
 */
@Service
public class CallInstallService {

    @Autowired
    private CrudTemplate crudTemplate;

    /**
     * 推送安装单信息
     *
     * @param installSheet
     */
    public void callInstall(InstallSheetInfos installSheet) throws Exception {

        if (installSheet.getCustomerType() == 1) {

        }
        /**
         * 如果是客户
         */
        if (installSheet.getCustomerType() == 0) {
            /**
             * 保存信息
             */
            installSheet = saveUserInstallSheet(installSheet);
            /**
             * 开始推送
             */
            pushInstallSheet(installSheet);

        }
        //Buyer buyer = new Buyer(installSheet.getCustomerType(), installSheet.getCustomerName(), installSheet.getCellphone(), installSheet.getTelephone(), installSheet.getDetailAdress());
        //crudTemplate.insert(buyer);
    }

    private void pushInstallSheet(InstallSheetInfos installSheet) throws Exception {

        // 客户类型
        int customerType = installSheet.getCustomerType();

        // 客户id
        Long customerId = installSheet.getCustomerId();

        // 安装地址
        String adress = installSheet.toAdress();

        // 产品序列号
        String psn = installSheet.getPsn();

        // 型号
        String model = installSheet.getModel();

        // 安装工id集合
        List<Long> installIdList = new ArrayList<>();





        /**
         * 获取城市关联的用户id
         */
        /*Adress adress1 = new Adress();
        adress1.setCity(installSheet.getCity());
        List<Adress> adressList = crudTemplate.gets(adress1);
        // 当前城市区域的用户id集合
        List<Long> rids = new ArrayList<>();
        for(Adress adress2 :adressList){
            rids.add(adress2.getRid());
        }*/


        /**
         * 获取安装工标签，及城市关联的用户id
         */
        Labels labels = new Labels();
        labels.setLabel(installSheet.getCity());
        labels.setType(Constants.UserLabels.INSTALLER.toString());
        // select * from labels where label='上海'
        List<Labels> userLabelList = crudTemplate.gets(labels);
        // select * from labels where rid in(....) where label='INSTALLER'
        //userLabelList = crudTemplate.ins();
        for (Labels ul : userLabelList) {
            installIdList.add(ul.getRid());
        }

        /**
         * 推送信息给安装工
         */













    }



    private InstallSheetInfos saveCompanyInstallSheet(InstallSheetInfos installInfos) throws Exception {

        Company company = new Company();
        company.setName(installInfos.getCustomerName());
        company.setCellphone(installInfos.getCellphone());
        company.setTelephone(installInfos.getTelephone());
        crudTemplate.insert(company);


        Adress adress = new Adress(company.getId(), installInfos.getProvince(), installInfos.getCity(), installInfos.getArea(), installInfos.getAdress());
        // 保存地址信息
        crudTemplate.insert(adress);

        /**
         * 初始化状态为0
         */
        InstallSheet installSheet = new InstallSheet(new Date(), installInfos.getPrecontractTime(), installInfos.getPsn(), 0);
        // 保存安装单
        crudTemplate.insert(installSheet);

        installInfos.setCustomerId(company.getId());

        return null;
    }


    private InstallSheetInfos saveUserInstallSheet(InstallSheetInfos installInfos) throws Exception {
        boolean flag = false;
        try {
            User user = new User();
            user.setName(installInfos.getCustomerName());
            user.setCellphone(installInfos.getCellphone());
            user.setTelephone(installInfos.getTelephone());
            // 保存用户信息
            crudTemplate.insert(user);

            Adress adress = new Adress(user.getId(), installInfos.getProvince(), installInfos.getCity(), installInfos.getArea(), installInfos.getAdress());
            // 保存地址信息
            crudTemplate.insert(adress);

            /**
             * 初始化状态为0
             */
            InstallSheet installSheet = new InstallSheet(new Date(), installInfos.getPrecontractTime(), installInfos.getPsn(), 0);
            // 保存安装单
            crudTemplate.insert(installSheet);

            installInfos.setCustomerId(user.getId());

            flag = true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return installInfos;
    }

}
