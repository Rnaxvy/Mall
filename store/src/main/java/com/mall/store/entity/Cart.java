package com.mall.store.entity;

import java.util.Objects;

public class Cart extends BaseEntity{

    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Long price_neo;
    private Integer quantity;

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                ", price_neo=" + price_neo +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cid, cart.cid) && Objects.equals(uid, cart.uid) && Objects.equals(pid, cart.pid) && Objects.equals(price, cart.price) && Objects.equals(price_neo, cart.price_neo) && Objects.equals(quantity, cart.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cid, uid, pid, price, price_neo, quantity);
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

    public Long getPrice_neo() {
        return price_neo;
    }

    public void setPrice_neo(Long price_neo) {
        this.price_neo = price_neo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
