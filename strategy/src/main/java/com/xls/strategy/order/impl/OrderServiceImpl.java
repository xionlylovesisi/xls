package com.xls.strategy.order.impl;

import com.xls.strategy.order.IOrderService;
import com.xls.strategy.order.dto.OrderDTO;
import com.xls.strategy.order.support.HandlerContext;
import com.xls.strategy.order.support.IAbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xls
 * @date 2019-07-15
 * @description
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private HandlerContext handlerContext;
    @Override
    public String handle(OrderDTO orderDTO) {
        IAbstractHandler instance = handlerContext.getInstance(orderDTO.getType());
        return instance.handle(orderDTO);
    }
}
