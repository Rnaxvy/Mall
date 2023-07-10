package com.mall.store.mapper;

import com.mall.store.entity.Cart;
import com.mall.store.vo.CartVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CartMapper {
    Integer insert(Cart cart);
    Integer quantityChange(Integer cid,Integer num,String modified_user,Date modified_time);
    Cart getByUPid(Integer uid,Integer pid);
    List<CartVo> showByUid(Integer uid);

    Integer deleteByCid(Integer cid);
}
