package com.strategy.patterm.demo.enums;

/**
 * 商品枚举类型
 */
public enum GoodsEnum {
    ThridGoods(1),
    HuaJuGoods(2),
    UserGoods(3);

    private Integer i;

    GoodsEnum(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }
}
