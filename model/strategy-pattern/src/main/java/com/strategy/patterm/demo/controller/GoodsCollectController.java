package com.strategy.patterm.demo.controller;

import com.strategy.patterm.demo.bean.HuaJuGoods;
import com.strategy.patterm.demo.bean.ThridGoods;
import com.strategy.patterm.demo.goods.lmpl.HuaJuGoodsImpl;
import com.strategy.patterm.demo.goods.lmpl.ThridGoodsImpl;
import com.strategy.patterm.demo.service.ResolveGoods;

import java.util.List;

public class GoodsCollectController {

    /**
     * 第三方收集器的collect
     *
     * @param thridGoodsList
     */
    public static void thirdGoodsCollect(List<ThridGoods> thridGoodsList) {
        ResolveGoods resolveGoods = new ResolveGoods(new ThridGoodsImpl());
        resolveGoods.saveGoods(thridGoodsList);
    }

    /**
     * 华钜收集器的collect
     *
     * @param huaJuGoodsList
     */
    public static void huaJuGoodsCollect(List<HuaJuGoods> huaJuGoodsList) {
        ResolveGoods resolveGoods = new ResolveGoods(new HuaJuGoodsImpl());
        resolveGoods.saveGoods(huaJuGoodsList);
    }


    /**
     * 第三方收集器的查询
     *
     * @param id
     */
    public static void thirdGoodsQueryById(String id) {
        ResolveGoods resolveGoods = new ResolveGoods(new ThridGoodsImpl());
        resolveGoods.queryById(id);
    }

    /**
     * 华钜收集器的collect
     *
     * @param id
     */
    public static void huaJuGoodsQueryById(String id) {
        ResolveGoods resolveGoods = new ResolveGoods(new HuaJuGoodsImpl());
        resolveGoods.queryById(id);
    }
}
