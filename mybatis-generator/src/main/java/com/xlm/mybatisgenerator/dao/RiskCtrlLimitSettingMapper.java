package com.xlm.mybatisgenerator.dao;

import com.xlm.mybatisgenerator.model.RiskCtrlLimitSetting;

public interface RiskCtrlLimitSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RiskCtrlLimitSetting record);

    int insertSelective(RiskCtrlLimitSetting record);

    RiskCtrlLimitSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RiskCtrlLimitSetting record);

    int updateByPrimaryKey(RiskCtrlLimitSetting record);
}