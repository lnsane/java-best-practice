package com.strategy.patterm.demo.bean;

/**
 * 第三方商品
 */
public class ThridGoods extends BaseGoods {
    private String sku;
    private String color;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "ThridGoods{" +
                "sku='" + sku + '\'' +
                ", color='" + color + '\'' +
                "} " + super.toString();
    }
}
