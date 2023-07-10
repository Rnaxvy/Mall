package com.mall.store.mapper;

import com.mall.store.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> hotList();
    Product detailByPid(Integer pid);
}
