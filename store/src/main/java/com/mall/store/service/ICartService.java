package com.mall.store.service;

import com.mall.store.entity.Cart;
import com.mall.store.entity.User;
import com.mall.store.vo.CartVo;

import java.util.List;

public interface ICartService {
    void addToCart(Integer uid,Integer pid,Integer num,String username);
    List<CartVo> showByUid(Integer uid);
    void deleteCart(Integer cid);
}
