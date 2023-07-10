package com.mall.store.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

//@Component
public class User extends BaseEntity{
    private Integer uid;
    private String username;
    private String password;
    private String favor;
    private String phone;
    private String email;
    private String gender;
    private String avatar;
    private Integer is_delete;
    //get&set

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    //equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return gender == user.gender && Objects.equals(uid, user.uid) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(favor, user.favor) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(avatar, user.avatar) && Objects.equals(is_delete, user.is_delete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uid, username, password, favor, phone, email, gender, avatar, is_delete);
    }

    //toString

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", favor='" + favor + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", isDelete=" + is_delete +
                '}';
    }

    public User(){}
    public User(Integer uid, String username, String avatar) {
        this.uid = uid;
        this.username = username;
        this.avatar = avatar;
    }
}
