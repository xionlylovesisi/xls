package com.xlm.springel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * @author xls
 * @date 2019-05-09
 * @description
 */
@Service
public class ParseElService {
    @Autowired
    private ExpressionParser expressionParser;
    @Autowired
    private StandardEvaluationContext standardEvaluationContext;
    public Object parse(@Nullable String elExpress){
        return expressionParser.parseExpression(elExpress).getValue(standardEvaluationContext);
    }
}
