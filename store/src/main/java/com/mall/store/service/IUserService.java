package com.mall.store.service;

import com.mall.store.entity.User;

public interface IUserService {
    void reg(User user);
    User login(String username,String password);
    User getByUid(Integer uid);
    void changeInfo(User user,Integer uid,String username);
}
