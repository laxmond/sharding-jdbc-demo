package com.cas.shardingjdbcdemo;

import com.cas.shardingjdbcdemo.entity.User;
import com.cas.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReadWriteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setUname("张三丰");
        userMapper.insert(user);
    }
}
