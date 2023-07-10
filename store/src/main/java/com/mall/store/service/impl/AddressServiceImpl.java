package com.mall.store.service.impl;

import com.mall.store.entity.Address;
import com.mall.store.mapper.AddressMapper;
import com.mall.store.service.IAddressService;
import com.mall.store.service.ex.AddressCountLimitException;
import com.mall.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Value("${address.maxCount}")
    private Integer maxCount;
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count=addressMapper.countLimit(uid);
        if(count>=maxCount){
            throw new AddressCountLimitException("收货地址超出上限");
        }
        address.setUid(uid);
        Integer isDefault=count==0?1:0;
        address.setIs_default(isDefault);
        address.setCreated_user(username);
        address.setModified_user(username);
        Date date=new Date();
        address.setCreated_time(date);
        address.setModified_time(date);
        Integer rows= addressMapper.insert(address);
        if(rows!=1){
            throw new InsertException("插入异常");
        }
    }

    @Override
    public List<Address> getAddressByUid(Integer uid) {
        return addressMapper.getByUid(uid);
    }

    @Override
    public Address findByAid(Integer aid) {
        return addressMapper.findByAid(aid);
    }

    @Override
    public void updateAddress(Address address, String modified_user, Date modified_time,boolean changeDefault) {
        addressMapper.updateByAid(address,modified_user,modified_time);
        if(changeDefault){
            addressMapper.updateNoneDefault();
            addressMapper.updateDefault(address.getAid());
        }
    }

    @Override
    public Integer defaultJudge(Integer aid) {
        return addressMapper.defaultJudge(aid);
    }

    @Override
    public void deleteByAid(Integer aid) {
        addressMapper.delete(aid);
    }


}



