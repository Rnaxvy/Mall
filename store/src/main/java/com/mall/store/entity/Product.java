package com.mall.store.entity;

import java.util.Objects;

public class Product extends BaseEntity{
    private Integer pid;
    private String title;
    private String type;
    private String sell_point;
    private Long price;
    private Integer num;
    private String image;
    private Integer statue;
    private Integer priority;

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", sell_point='" + sell_point + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", statue=" + statue +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(pid, product.pid) && Objects.equals(title, product.title) && Objects.equals(type, product.type) && Objects.equals(sell_point, product.sell_point) && Objects.equals(price, product.price) && Objects.equals(num, product.num) && Objects.equals(image, product.image) && Objects.equals(statue, product.statue) && Objects.equals(priority, product.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pid, title, type, sell_point, price, num, image, statue, priority);
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSell_point() {
        return sell_point;
    }

    public void setSell_point(String sell_point) {
        this.sell_point = sell_point;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
