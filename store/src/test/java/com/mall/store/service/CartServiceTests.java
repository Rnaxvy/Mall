package com.mall.store.service;

import com.mall.store.entity.User;
import com.mall.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)//启动这个单元测试类，否则不可运行，参数固定
public class CartServiceTests {

    @Autowired
    private ICartService cartService;

    @Test
    //单元测试必须是public void，必须无参数
    public void add(){
        cartService.addToCart(1,2,3,"you");
    }

    @Test
    public void delete(){
        cartService.deleteCart(3);
    }
}
