package com.xls.strategy.order.support;

import com.xls.strategy.utils.SpringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author xls
 * @date 2019-07-15
 * @description
 */
public class HandlerContext {
    private Map<String,Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }
    public IAbstractHandler getInstance(String type){
        Class clazz = handlerMap.get(type);
        if (Objects.isNull(clazz)) {
            throw new IllegalArgumentException("not found handler for type :"+type );
        }
        IAbstractHandler bean = (IAbstractHandler) SpringUtils.getApplicationContext().getBean(clazz);
        return bean;
    }


}
