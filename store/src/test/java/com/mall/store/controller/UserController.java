package com.mall.store.controller;

import com.mall.store.entity.User;
import com.mall.store.service.IUserService;
import com.mall.store.service.ex.InsertException;
import com.mall.store.service.ex.UsernameDuplicatedException;
import com.mall.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("reg")
    @ResponseBody
    public JsonResult<Void> reg(User user){
        JsonResult<Void> result=new JsonResult<>();
        try {
            userService.reg(user);
            result.setState(200);
            result.setMessage("注册成功");
        } catch (UsernameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名不可用");
        } catch (InsertException e){
            result.setState(5000);
            result.setMessage("未知冲突");
        }
        return result;
    }

    @RequestMapping("hel")
    @ResponseBody
    public String hello()
    {
        return "hello";
    }
}
