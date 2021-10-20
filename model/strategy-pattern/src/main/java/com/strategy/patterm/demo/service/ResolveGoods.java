package com.strategy.patterm.demo.service;

import com.strategy.patterm.demo.bean.BaseGoods;
import com.strategy.patterm.demo.goods.GoodsInface;

import java.util.List;

/**
 * 商品解析类
 */
public class ResolveGoods {

    private GoodsInface goodsInface;


    public ResolveGoods(GoodsInface goodsInface) {
        this.goodsInface = goodsInface;
    }


    public void saveGoods(List<? extends BaseGoods> c) {
        goodsInface.save(c);
    }

    public Object queryById(String id) {
        return goodsInface.findById(id);
    }


}
