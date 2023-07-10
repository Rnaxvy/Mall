package com.mall.store.vo;

import java.io.Serializable;
import java.util.Objects;

public class CartVo implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer quantity;
    private Integer num;
    private String title;
    private String image;
    private Long price_neo;

    @Override
    public String toString() {
        return "CartVo{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                ", quantity=" + quantity +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price_neo=" + price_neo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartVo cartVo = (CartVo) o;
        return Objects.equals(cid, cartVo.cid) && Objects.equals(uid, cartVo.uid) && Objects.equals(pid, cartVo.pid) && Objects.equals(price, cartVo.price) && Objects.equals(quantity, cartVo.quantity) && Objects.equals(num, cartVo.num) && Objects.equals(title, cartVo.title) && Objects.equals(image, cartVo.image) && Objects.equals(price_neo, cartVo.price_neo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, uid, pid, price, quantity, num, title, image, price_neo);
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getPrice_neo() {
        return price_neo;
    }

    public void setPrice_neo(Long price_neo) {
        this.price_neo = price_neo;
    }
}
