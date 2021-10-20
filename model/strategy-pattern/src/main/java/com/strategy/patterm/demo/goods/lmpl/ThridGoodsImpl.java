package com.strategy.patterm.demo.goods.lmpl;

import com.strategy.patterm.demo.bean.BaseGoods;
import com.strategy.patterm.demo.bean.ThridGoods;
import com.strategy.patterm.demo.goods.GoodsInface;

import java.util.List;

public class ThridGoodsImpl implements GoodsInface {

    @Override
    public void save(List<? extends BaseGoods> c) {
        System.out.println("商品的数据是 ： +++++++++++++++++");
        for (ThridGoods thridGoods : (List<ThridGoods>) c) {
            System.out.println(thridGoods.toString());
        }
    }

    @Override
    public Object findById(String id) {
        ThridGoods thridGoods = new ThridGoods();
        thridGoods.setSku("123");
        thridGoods.setColor("red");
        thridGoods.setId("1234");
        thridGoods.setUserName("12345");
        thridGoods.setPrice("1");
        System.out.println("查询的数据是" + thridGoods.toString());
        return thridGoods;
    }
}
