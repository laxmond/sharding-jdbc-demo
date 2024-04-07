package com.cas.shardingjdbcdemo.controller;

import com.cas.shardingjdbcdemo.entity.Order;
import com.cas.shardingjdbcdemo.mapper.OrderMapper;
import com.cas.shardingjdbcdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/selectAll")
    public void selectAll() {
        orderMapper.selectList(null);
    }

    @GetMapping("/insert")
    public void insert() {
        long i = (long) (Math.random() * 100);
        Order order = new Order();
        order.setUserId(i % 2);
        order.setOrderNo("X00" + i);
        order.setAmount(BigDecimal.valueOf(10));

        orderMapper.insert(order);
    }
}
