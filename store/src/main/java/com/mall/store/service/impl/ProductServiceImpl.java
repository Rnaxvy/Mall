package com.mall.store.service.impl;

import com.mall.store.entity.Product;
import com.mall.store.mapper.ProductMapper;
import com.mall.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> hotList() {
        List<Product> list=productMapper.hotList();
        //数据瘦身
        for(Product product:list){
            product.setPriority(null);
            product.setCreated_time(null);
            product.setCreated_user(null);
            product.setModified_time(null);
            product.setModified_user(null);
        }
        return list;
    }

    @Override
    public Product productDetail(Integer pid) {
        Product product=productMapper.detailByPid(pid);//数据瘦身
            product.setCreated_time(null);
            product.setCreated_user(null);
            product.setModified_time(null);
            product.setModified_user(null);
        return product;
    }
}
