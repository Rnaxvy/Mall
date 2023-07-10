package com.mall.store.mapper;

import com.mall.store.entity.Address;
import com.mall.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)//启动这个单元测试类，否则不可运行，参数固定
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    //单元测试必须是public void，必须无参数
    public void insert(){
        Address address=new Address();
        address.setUid(9);
        address.setName("die");
        address.setPhone("159635456");
        Integer rows= addressMapper.insert(address);
        System.out.println(rows);
    }

    @Test
    public void countLimit(){
        Integer count= addressMapper.countLimit(9);
        System.out.println(count);
    }

    @Test
    public void updateByAid(){
        Address address=new Address();
        address.setAid(5);
        address.setName("new");
        address.setPhone("147147147");
        addressMapper.updateByAid(address,"a",new Date());
        addressMapper.updateNoneDefault();
        addressMapper.updateDefault(address.getAid());
    }

    @Test
    public void findByAid(){
        System.out.println(addressMapper.findByAid(8));
    }

    @Test
    public void delete(){addressMapper.delete(9);}
}
