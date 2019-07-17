package com.xls.strategy.order;

import com.xls.strategy.order.dto.OrderDTO;

public interface IOrderService {
    /**
     * 返回订单类型
     * @param orderDTO
     * @return
     */
    String handle(OrderDTO orderDTO);
}
