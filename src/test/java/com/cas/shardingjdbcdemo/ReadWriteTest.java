package com.cas.shardingjdbcdemo;

import com.cas.shardingjdbcdemo.entity.User;
import com.cas.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ReadWriteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUname("李四");
        userMapper.insert(user);
    }

    @Transactional // 开启事务
    @Test
    public void testTrans() {
        User user = new User();
        user.setUname("铁锤");
        userMapper.insert(user);

        List<User> users = userMapper.selectList(null);
    }

    @Test
    public void testSelect() {
        List<User> users1 = userMapper.selectList(null);
        List<User> users2 = userMapper.selectList(null);
//        users.forEach(System.out::println);
    }
}
