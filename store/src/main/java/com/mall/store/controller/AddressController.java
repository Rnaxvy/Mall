package com.mall.store.controller;

import com.mall.store.entity.Address;
import com.mall.store.service.IAddressService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="address")
public class AddressController extends BaseController{

    @Autowired
    private IAddressService addressService;

    @RequestMapping("show")
    public String toAddress(HttpSession session, Model model){
        List<Address> addressList = addressService.getAddressByUid(getUidFromSession(session));
        model.addAttribute("addresses",addressList);
        return "addressPage";
    }

    @RequestMapping("toAdd")
    public String toAddNewAddress(){
        return "addressAddPage";
    }

    @RequestMapping("add")
    public String addNewAddress(HttpSession session,String name,String phone ){
        Address address=new Address();
        address.setName(name);
        address.setPhone(phone);
        addressService.addNewAddress(getUidFromSession(session),getUsernameFromSession(session),address);
        return "mainPage";
    }

    @RequestMapping("/{aid}/toUpdate")
    public String toChange(@PathVariable Integer aid,Model model){
        Address address=addressService.findByAid(aid);
        model.addAttribute("address",address);
        return "updateAddress";
    }

    @RequestMapping("/{aid}/update")
    public String changeInfo(@PathVariable Integer aid,
                             Integer is_default,
                             Address address,
                             HttpSession session){
        boolean change=false;
        if(is_default==1){
            if(addressService.defaultJudge(aid)==0)
            {
                change=true;
            }
        }
        addressService.updateAddress(address,getUsernameFromSession(session),new Date(),change);
        return "mainPage";
    }

    @RequestMapping("/{aid}/delete")
    public String deleteAddress(@PathVariable Integer aid){
        addressService.deleteByAid(aid);
        return "mainPage";
    }
}
