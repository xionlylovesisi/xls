package com.xlm.springel.mapper;


import com.xlm.springel.model.ElExpression;

public interface ElExpressionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ElExpression record);

    int insertSelective(ElExpression record);

    ElExpression selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ElExpression record);

    int updateByPrimaryKey(ElExpression record);
}