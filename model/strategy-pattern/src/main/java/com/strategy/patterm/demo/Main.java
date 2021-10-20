package com.strategy.patterm.demo;

import com.strategy.patterm.demo.bean.HuaJuGoods;
import com.strategy.patterm.demo.bean.ThridGoods;
import com.strategy.patterm.demo.controller.GoodsCollectController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ThridGoods thridGoods = new ThridGoods();
        thridGoods.setSku("123");
        thridGoods.setColor("red");
        thridGoods.setId("1234");
        thridGoods.setUserName("12345");
        thridGoods.setPrice("1");
        List<ThridGoods> thridGoodsList = new ArrayList<>();
        thridGoodsList.add(thridGoods);
        GoodsCollectController.thirdGoodsCollect(thridGoodsList);

        HuaJuGoods huaJuGoods = new HuaJuGoods();
        huaJuGoods.setCompanyId("0001");
        huaJuGoods.setCompanyName("华钜");
        huaJuGoods.setId("123123123");
        huaJuGoods.setUserName("炫彩服装");
        huaJuGoods.setPrice("1000");

        List<HuaJuGoods> huaJuGoodsList = new ArrayList<>();
        huaJuGoodsList.add(huaJuGoods);
        GoodsCollectController.huaJuGoodsCollect(huaJuGoodsList);


        GoodsCollectController.huaJuGoodsQueryById("10");
        GoodsCollectController.thirdGoodsQueryById("110");

    }
}
