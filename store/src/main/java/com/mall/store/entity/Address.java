package com.mall.store.entity;

import java.util.Objects;

public class Address extends BaseEntity{
    Integer aid;
    Integer uid;
    String name;
    String province_name;
    String city_name;
    String area_name;
    String area_code;
    String zip;
    String addr;
    String phone;
    String tel;
    String tag;
    Integer is_default;

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", province_name='" + province_name + '\'' +
                ", city_name='" + city_name + '\'' +
                ", area_name='" + area_name + '\'' +
                ", area_code='" + area_code + '\'' +
                ", zip='" + zip + '\'' +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", tag='" + tag + '\'' +
                ", is_default=" + is_default +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Address address = (Address) o;
        return Objects.equals(aid, address.aid) && Objects.equals(uid, address.uid) && Objects.equals(name, address.name) && Objects.equals(province_name, address.province_name) && Objects.equals(city_name, address.city_name) && Objects.equals(area_name, address.area_name) && Objects.equals(area_code, address.area_code) && Objects.equals(zip, address.zip) && Objects.equals(addr, address.addr) && Objects.equals(phone, address.phone) && Objects.equals(tel, address.tel) && Objects.equals(tag, address.tag) && Objects.equals(is_default, address.is_default);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), aid, uid, name, province_name, city_name, area_name, area_code, zip, addr, phone, tel, tag, is_default);
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getIs_default() {
        return is_default;
    }

    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }
}
