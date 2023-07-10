package com.mall.store.service.impl;

import com.mall.store.entity.User;
import com.mall.store.mapper.UserMapper;
import com.mall.store.service.IUserService;
import com.mall.store.service.ex.PasswordWrongException;
import com.mall.store.service.ex.UpdateException;
import com.mall.store.service.ex.UsernameDuplicatedException;
import com.mall.store.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
        String username=user.getUsername();
        //先判断是否昵称重复
        User res= userMapper.findByUsername(username);
        if(res!=null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

        //若没有异常，则没有昵称冲突
        user.setIs_delete(0);
        user.setCreated_user(user.getUsername());
        user.setModified_user(user.getModified_user());
        Date date=new Date();
        user.setCreated_time(date);
        user.setModified_time(date);

        //密码加密
        String oldPassword=user.getPassword();
        String salt= UUID.randomUUID().toString().toUpperCase();
        String newPassword=getMD5Password(oldPassword,salt);
        user.setPassword(newPassword);
        user.setFavor(salt);

        Integer rows=userMapper.insert(user);
        if(rows!=1){
            //极小概率事件：多个用户同时注册同一昵称
            throw new UsernameDuplicatedException("未知异常");
        }
    }

    @Override
    public User login(String username, String password) {
        User res=userMapper.findByUsername(username);
        //异常处理
        if(res==null){
            throw new UserNotFoundException("用户不存在");
        }
        String salt=res.getFavor();
        String pass=getMD5Password(password,salt);
        if(!pass.equals(res.getPassword())){
            throw new PasswordWrongException("密码错误");
        }
        if(res.getIs_delete()==1){
            throw new UserNotFoundException("用户已注销");
        }

        //查询得来的对象数据庞大，需进行瘦身
        User user=new User(res.getUid(), res.getUsername(), res.getAvatar());
        return user;
    }

    @Override
    public User getByUid(Integer uid) {
        User res=userMapper.getByUid(uid);
        if(res==null||res.getIs_delete()==1){
            throw new UserNotFoundException("用户不存在");
        }
        //数据瘦身
        User user=new User();
        user.setUsername(res.getUsername());
        user.setPhone(res.getPhone());
        user.setEmail(res.getEmail());
        user.setGender(res.getGender());
        return user;
    }

    @Override
    public void changeInfo(User user, Integer uid, String username) {
        User res=userMapper.getByUid(uid);
        if(res==null||res.getIs_delete()==1){
            throw new UserNotFoundException("用户不存在");
        }
        user.setUid(uid);
        user.setModified_user(username);
        user.setModified_time(new Date());
        Integer row=userMapper.updateByUid(user);
        if(row!=1){
            throw new UpdateException("更新异常");
        }
    }

    private String getMD5Password(String password,String salt){
        for(int i=0;i<3;i++)
        {
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
