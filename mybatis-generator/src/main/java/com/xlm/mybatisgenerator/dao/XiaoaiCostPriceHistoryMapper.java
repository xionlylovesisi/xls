package com.xlm.mybatisgenerator.dao;

import com.xlm.mybatisgenerator.model.XiaoaiCostPriceHistory;

public interface XiaoaiCostPriceHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XiaoaiCostPriceHistory record);

    int insertSelective(XiaoaiCostPriceHistory record);

    XiaoaiCostPriceHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XiaoaiCostPriceHistory record);

    int updateByPrimaryKey(XiaoaiCostPriceHistory record);
}