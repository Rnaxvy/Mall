package com.mall.store.mapper;

import com.mall.store.entity.Address;
import com.mall.store.entity.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)//启动这个单元测试类，否则不可运行，参数固定
public class CartMapperTests {

    @Autowired
    private CartMapper cartMapper;

    @Test
    //单元测试必须是public void，必须无参数
    public void insert(){
        Cart cart =new Cart();
        cart.setCid(1);
        cart.setPid(2);
        cart.setUid(3);
        cart.setPrice(30l);
        cart.setPrice_neo(40l);
        Integer rows= cartMapper.insert(cart);
        System.out.println(rows);
    }

    @Test
    public void getByCid(){
        if(cartMapper.getByUPid(2,2)==null)
        System.out.println("1");
        else System.out.println("2");
    }
    @Test
    public void addProductToCart(){
        cartMapper.quantityChange(1,30,"me",new Date());
    }

    @Test
    public void show(){
        System.out.println(cartMapper.showByUid(1));
    }
}
