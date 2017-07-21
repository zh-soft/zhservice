package com.zh.dictionary.mapper;

import com.zh.pojo.DistrictInfos;

import java.util.List;

/**
 * Created by Lait on 2017/7/20.
 */
public interface LabelMapper {

    /**
     * 根据id获取
     * @param id
     * @return
     */
    DistrictInfos getById(Long id);

    /**
     * 根据id获取子节点
     * @param id
     * @return
     */
    List<DistrictInfos> selectChildrenById(Long id);

    /**
     * 获取字典信息
     * @param dictionaryInfos
     * @return
     */
    List<DistrictInfos> getLabelInfos(DistrictInfos dictionaryInfos);



}
