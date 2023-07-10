package com.mall.store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//实体类的基类
public class BaseEntity implements Serializable {
    private String created_user;
    private Date created_time;
    private String modified_user;
    private Date modified_time;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "created_user='" + created_user + '\'' +
                ", created_time=" + created_time +
                ", modified_user='" + modified_user + '\'' +
                ", modified_time=" + modified_time +
                '}';
    }

    public String getCreated_user() {
        return created_user;
    }

    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(created_user, that.created_user) && Objects.equals(created_time, that.created_time) && Objects.equals(modified_user, that.modified_user) && Objects.equals(modified_time, that.modified_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created_user, created_time, modified_user, modified_time);
    }

    public String getModified_user() {
        return modified_user;
    }

    public void setModified_user(String modified_user) {
        this.modified_user = modified_user;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }
}
