package com.mall.store.service;

import com.mall.store.entity.Address;
import com.mall.store.entity.User;

import java.util.Date;
import java.util.List;

public interface IAddressService {
    void addNewAddress(Integer uid, String username, Address address);
    List<Address> getAddressByUid(Integer uid);
    Address findByAid(Integer aid);
    void updateAddress(Address address,String modified_user, Date modified_time,boolean changeDefault);
    Integer defaultJudge(Integer aid);

    void deleteByAid(Integer aid);
}
