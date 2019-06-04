package com.xlm.springel.config;

import com.xlm.springel.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author xls
 * @date 2019-05-09
 * @description spring el config
 */
@Configuration
public class SpringElConfig{
    @Bean
    public ExpressionParser expressionParser(){
        ExpressionParser parser = new SpelExpressionParser();
        return parser;
    }
    @Bean
    @Autowired
    public StandardEvaluationContext standardEvaluationContext(SpringUtils springUtils){
        StandardEvaluationContext context = new StandardEvaluationContext();
        BeanFactoryResolver beanFactoryResolver = new BeanFactoryResolver(springUtils.getApplicationContext());
        context.setBeanResolver(beanFactoryResolver);
        return context;
    }

}
