package com.cas.shardingjdbcdemo.controller;

import com.cas.shardingjdbcdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/selectAll")
    public void selectAll() {
        userMapper.selectList(null);
    }
}
