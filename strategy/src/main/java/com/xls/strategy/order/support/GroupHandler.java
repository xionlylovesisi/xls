package com.xls.strategy.order.support;

import com.xls.strategy.order.dto.OrderDTO;
import com.xls.strategy.order.support.IAbstractHandler;
import org.springframework.stereotype.Component;

/**
 * @author xls
 * @date 2019-07-15
 * @description
 */
@Component
@HandlerType("2")
public class GroupHandler implements IAbstractHandler {
    @Override
    public String handle(OrderDTO orderDTO) {
        return "处理团购订单";
    }
}
