package com.mall.store.service.impl;

import com.mall.store.entity.Cart;
import com.mall.store.mapper.CartMapper;
import com.mall.store.mapper.ProductMapper;
import com.mall.store.service.ICartService;
import com.mall.store.service.ex.DeleteException;
import com.mall.store.service.ex.InsertException;
import com.mall.store.service.ex.UpdateException;
import com.mall.store.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void addToCart(Integer uid,Integer pid,Integer num,String username) {
        Cart res=cartMapper.getByUPid(uid,pid);
        Date date=new Date();
        if(res==null){
            Cart cart=new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setQuantity(num);
            Long price=productMapper.detailByPid(pid).getPrice();
            cart.setPrice(price);
            cart.setPrice_neo(price);
            cart.setCreated_user(username);
            cart.setModified_user(username);
            cart.setModified_time(date);
            cart.setCreated_time(date);
            Integer rows= cartMapper.insert(cart);
            if(rows!=1){
                throw new InsertException("插入异常");
            }
        }
        else{
            Integer rows= cartMapper.quantityChange(res.getCid(),num,username,date);
            if(rows!=1){
                throw new UpdateException("更新异常");
            }
        }
    }

    @Override
    public List<CartVo> showByUid(Integer uid) {
        return cartMapper.showByUid(uid);
    }

    @Override
    public void deleteCart(Integer cid) {
        Integer rows=cartMapper.deleteByCid(cid);
        if(rows!=1){
            throw new DeleteException("删除异常");
        }
    }
}
