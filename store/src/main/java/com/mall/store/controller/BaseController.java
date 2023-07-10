package com.mall.store.controller;

import com.mall.store.service.ex.*;
import com.mall.store.util.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class BaseController {
    public static final int OK=200;     //操作成功返回码
    @ExceptionHandler(ServiceException.class)   //异常会被同一拦截至此
    //@ResponseBody
    public String handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException)
        {
            result.setState(4000);
            result.setMessage("用户名不可用");
        }
        else if (e instanceof InsertException)
        {
            result.setState(5000);
            result.setMessage("未知冲突");
        }else if(e instanceof UserNotFoundException)
        {
            result.setState(5001);
            result.setMessage("用户不存在");
        }
        else if(e instanceof PasswordWrongException)
        {
            result.setState(5002);
            result.setMessage("密码错误");
        }
        else if(e instanceof UpdateException)
        {
            result.setState(5003);
            result.setMessage("更新异常");
            return "updateFailed";
        }
        else if(e instanceof AddressCountLimitException)
        {
            result.setState(6000);
            result.setMessage("地址超限");
        }
        return "loginFailed";
    }

    protected final Integer getUidFromSession(HttpSession session)
    {
        if(session.getAttribute("uid")!=null){
            return Integer.valueOf(session.getAttribute("uid").toString()) ;
        }
       return null;
    }
    protected final String getUsernameFromSession(HttpSession session)
    {
        return session.getAttribute("username").toString() ;
    }
}
