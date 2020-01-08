package com.xls.strategy.order.support;

import com.xls.strategy.order.dto.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * @author xls
 * @date 2019-07-15
 * @description
 */
@Component
@HandlerType("1")
public class NormalHandler implements IAbstractHandler {
    @Override
    public String handle(OrderDTO orderDTO) {
        return "处理普通订单";
    }
}
