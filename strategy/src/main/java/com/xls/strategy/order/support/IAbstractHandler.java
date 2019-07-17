package com.xls.strategy.order.support;

import com.xls.strategy.order.dto.OrderDTO;

public interface IAbstractHandler {
    String handle(OrderDTO orderDTO);
}
