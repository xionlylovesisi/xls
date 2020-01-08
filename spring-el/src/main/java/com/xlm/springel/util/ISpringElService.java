package com.xlm.springel.util;

import com.xlm.springel.mapper.ElExpressionMapper;
import com.xlm.springel.model.ElExpression;
import com.xlm.springel.service.ParseElService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xls
 * @date 2019-05-09
 * @description
 */
public interface ISpringElService {
    public Object getElResult(Integer elId);
    public Integer getA(Integer a);
    public  Integer getB(Integer a);
    public Integer getC(Integer a);
}
