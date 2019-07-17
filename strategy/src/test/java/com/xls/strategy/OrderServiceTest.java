package com.xls.strategy;
import java.math.BigDecimal;

import com.xls.strategy.order.IOrderService;
import com.xls.strategy.order.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private IOrderService iOrderService;
    @Test
    public void handleTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCode("123");
        orderDTO.setPrice(new BigDecimal("20"));
        orderDTO.setType("1");
        System.out.println("::::::----->"+iOrderService.handle(orderDTO));

    }
}
