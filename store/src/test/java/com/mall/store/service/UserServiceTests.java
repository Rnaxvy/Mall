package com.mall.store.service;

import com.mall.store.entity.User;
import com.mall.store.mapper.UserMapper;
import com.mall.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)//启动这个单元测试类，否则不可运行，参数固定
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    //单元测试必须是public void，必须无参数
    public void reg(){
        try{
            User user=new User();
            user.setUsername("dit");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("OK");
        }catch(ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void login(){
        userService.login("cat","123");
    }

    @Test
    public void getByUid(){
        System.out.println(userService.getByUid(16));
    }

    @Test
    public void changeInfo(){
        User user=new User();
        user.setPhone("156");
        user.setEmail("156@156.com");
        user.setGender("男");
        userService.changeInfo(user,15,"admin");
    }
}
