package com.mall.store.controller;

import com.mall.store.service.IProductService;
import com.mall.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProduceController extends BaseController{
    @Autowired
    private IProductService productService;

    @RequestMapping("/{pid}/detail")
    public String showDetail(@PathVariable Integer pid,Model model)
    {
        model.addAttribute("product",productService.productDetail(pid));
        return "productDetail";
    }
}
