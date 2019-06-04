package com.xlm.springel.service;

import com.xlm.springel.mapper.ElExpressionMapper;
import com.xlm.springel.model.ElExpression;
import com.xlm.springel.util.ISpringElService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xls
 * @date 2019-05-09
 * @description
 */
@Service
public class SpringElService implements ISpringElService {
    @Autowired
    private ElExpressionMapper elExpressionMapper;
    @Autowired
    private ParseElService parseElService;
    public Object getElResult(Integer elId){
        ElExpression elExpression = elExpressionMapper.selectByPrimaryKey(elId);
        return parseElService.parse(elExpression.getExpression());
    }
    @Override
    public Integer getA(Integer a){
        return a;
    }
    @Override
    public  Integer getB(Integer a){
        return -1;
    }
    @Override
    public Integer getC(Integer a){
        return 22;
    }
}
