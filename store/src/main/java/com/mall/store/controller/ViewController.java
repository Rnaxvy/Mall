package com.mall.store.controller;

import com.mall.store.service.IProductService;
import com.mall.store.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController extends BaseController{
    @Autowired
    private IProductService productService;

    @RequestMapping({"/login"})
    public String login()
    {
        return "login";
    }

    @RequestMapping({"/users/register"})
    public String register()
    {
        return "register";
    }

    @RequestMapping("hell")
    public String hello()
    {
        return "hello";
    }

    @RequestMapping({"/","/index"})
    public String index(Model model, HttpSession session)
    {
        if(session != null )
        {
            if(session != null && session.getAttribute("uid")!=null &&getUidFromSession(session) != null)
            model.addAttribute("alreadyLogin",1);
        }
        model.addAttribute("products",productService.hotList());
        return "index";
    }
}
