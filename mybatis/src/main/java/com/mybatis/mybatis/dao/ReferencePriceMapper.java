package com.mybatis.mybatis.dao;

import com.mybatis.mybatis.model.ReferencePrice;

public interface ReferencePriceMapper {
    int insert(ReferencePrice record);

    int insertSelective(ReferencePrice record);
}