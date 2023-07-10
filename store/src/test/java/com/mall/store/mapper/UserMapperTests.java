package com.mall.store.mapper;

import com.mall.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)//启动这个单元测试类，否则不可运行，参数固定
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    //单元测试必须是public void，必须无参数
    public void insert(){
        User user=new User();
        user.setUsername("die");
        user.setPassword("123");
        Integer rows= userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void update(){
        User user=new User();
        user.setUid(9);
        user.setPhone("15955656330");
        user.setEmail("159@159.com");
        userMapper.updateByUid(user);
    }
}
