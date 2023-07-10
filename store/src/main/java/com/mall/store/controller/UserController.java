package com.mall.store.controller;

import com.mall.store.entity.User;
import com.mall.store.service.IUserService;

import com.mall.store.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//
@Controller
@RequestMapping(value="users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @RequestMapping(value="reg")
    @ResponseBody
    public JsonResult<Void> reg(User user){
        /*
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
        */
        userService.reg(user);
        return new JsonResult<>(OK);
    }
/*
    @RequestMapping("login")
    public ModelAndView login(String username, String password, HttpSession session)
    {
        ModelAndView toMain=new ModelAndView("mainPage");
        User data=userService.login(username,password);
        //存储至session
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

        toMain.addObject("userData",new JsonResult<User>(OK,data));
        return toMain;
    }
*/
    @RequestMapping("in")
    public String login(String username, String password, HttpSession session)
    {
        User data=userService.login(username,password);
        //存储至session
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

        return "redirect:/index";
    }

    @RequestMapping("userPage")
    public String toUser(HttpSession session, Model model){
        User data=userService.getByUid(getUidFromSession(session));
        if(data==null)return "login";
        model.addAttribute("user", data);
        return "userPage";
    }

    @RequestMapping("change")
    public String updateInfo(String phone,String email,String gender,HttpSession session){
        User user=new User();
        user.setPhone(phone);
        user.setEmail(email);
        user.setGender(gender);
        userService.changeInfo(user,getUidFromSession(session),getUsernameFromSession(session));
        return "mainPage";
    }

    @RequestMapping("addressPage")
    public String toAddress(HttpSession session, Model model){
        User data=userService.getByUid(getUidFromSession(session));
        if(data==null)return "loginFailed";
        model.addAttribute("user", data);
        return "addressAddPage";
    }
}
