package com.mall.store.controller;

import com.mall.store.entity.Cart;
import com.mall.store.service.ICartService;
import com.mall.store.vo.CartVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;

    @ResponseBody
    @RequestMapping("/{pid}/add/{buyNum}")
    public String addToCart(HttpSession session,
                          @PathVariable Integer pid,
                          @PathVariable Integer buyNum){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        cartService.addToCart(uid,pid,buyNum,username);
        return "操作成功";
    }


    @RequestMapping("show")
    public String showCartByUid(HttpSession session, Model model){
        Integer uid=getUidFromSession(session);
        List<CartVo> list= cartService.showByUid(uid);
        model.addAttribute("cartVos",list);
        return "cart";
    }

    @RequestMapping("cart/{cid}/delete")
    public String deleteCart(@PathVariable Integer cid){
        cartService.deleteCart(cid);
        return "redirect:/cart/show";
    }
}
