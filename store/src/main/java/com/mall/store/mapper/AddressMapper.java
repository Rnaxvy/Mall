package com.mall.store.mapper;

import com.mall.store.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface AddressMapper {
    Integer insert(Address address);
    Integer countLimit(Integer uid);
    List<Address> getByUid(Integer uid);
    Address findByAid(Integer aid);
    Integer updateByAid(Address address,String modified_user, Date modified_time);
    Integer updateNoneDefault();
    Integer updateDefault(Integer aid);
    Integer defaultJudge(Integer aid);
    Integer delete(Integer aid);
}
