package com.xls.strategy.order.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author xls
 * @date 2019-07-15
 * @description
 */
@Data
@ToString
public class OrderDTO {
    private String code;
    private BigDecimal price;
    private String type;
}
