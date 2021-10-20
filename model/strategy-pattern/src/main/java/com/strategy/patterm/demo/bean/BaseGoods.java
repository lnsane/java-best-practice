package com.strategy.patterm.demo.bean;

/**
 * 商品基本类型
 */
public class BaseGoods {
    private String id;
    private String userName;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BaseGoods{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
