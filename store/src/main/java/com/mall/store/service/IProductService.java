package com.mall.store.service;

import com.mall.store.entity.Product;
import com.mall.store.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IProductService {
    List<Product> hotList();
    Product productDetail(Integer pid);
}

