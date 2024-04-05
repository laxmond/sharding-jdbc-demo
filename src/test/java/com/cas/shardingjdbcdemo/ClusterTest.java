package com.cas.shardingjdbcdemo;

import com.cas.shardingjdbcdemo.entity.Order;
import com.cas.shardingjdbcdemo.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ClusterTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testInsert() {
        Order order = new Order();
        order.setUserId(1L);
        order.setOrderNo("X001");
        order.setAmount(BigDecimal.valueOf(10));

        orderMapper.insert(order);
    }

    @Test
    public void testInsertMulti() {
        for(long i = 0; i < 10L;i++) {
            Order order = new Order();
            order.setUserId(i % 2);
            order.setOrderNo("X00" + i);
            order.setAmount(BigDecimal.valueOf(10));

            orderMapper.insert(order);
        }
    }
}
