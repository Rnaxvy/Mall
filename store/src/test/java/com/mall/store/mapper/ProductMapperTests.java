package com.mall.store.mapper;

import com.mall.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)//启动这个单元测试类，否则不可运行，参数固定
public class ProductMapperTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    //单元测试必须是public void，必须无参数
    public void show(){
        System.out.println(productMapper.hotList());
    }

    @Test
    public void getByPid(){
        System.out.println(productMapper.detailByPid(3));
    }
}
