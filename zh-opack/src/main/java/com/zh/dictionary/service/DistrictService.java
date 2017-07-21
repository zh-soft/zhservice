package com.zh.dictionary.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.zh.dictionary.entity.Labels;
import com.zh.pojo.DistrictInfos;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lait on 2017/7/18.
 */
@Service
public class DistrictService {

    @Autowired
    private CrudTemplate crudTemplate;

    /**
     * ---------------------------------------------------------------------------------------------------------------
     * id               pid            type                key                 value               code                description
     * 1                null           user                labels              installer           1                   安装人员
     * 2                null           product             series              日系列               1                   产品系类
     * 3                null           address             province            安徽省               1                   省份
     * 4                3              address             city                滁州市               0550                市
     * 5                4              address             area                琅玡区               0                   区
     * 6                null
     *
     *
     * @param dictionaryInfos
     * @throws Exception
     */
    public void addDic(DistrictInfos dictionaryInfos) throws Exception {
        Labels dictionary = new Labels();
        BeanUtils.copyProperties(dictionaryInfos,dictionary);
        crudTemplate.insert(dictionary);
    }
}
