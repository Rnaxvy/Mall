package com.mall.store.mapper;

import com.mall.store.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
//在主类进行mapper扫描
public interface UserMapper {
    Integer insert(User user);
    User findByUsername(String username) ;
    User getByUid(Integer uid);
    Integer updateByUid(User user);
    Integer updateAvatarByUid(Integer uid,
                              String avatar,
                              String modified_user,
                              Date modified_time);

}
