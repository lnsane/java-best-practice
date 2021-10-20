package com.strategy.patterm.demo.goods.lmpl;

import com.strategy.patterm.demo.bean.BaseGoods;
import com.strategy.patterm.demo.bean.HuaJuGoods;
import com.strategy.patterm.demo.goods.GoodsInface;

import java.util.List;

public class HuaJuGoodsImpl implements GoodsInface {
    @Override
    public void save(List<? extends BaseGoods> c) {
        System.out.println("商品的数据是 ： +++++++++++++++++");
        for (HuaJuGoods thridGoods : (List<HuaJuGoods>) c) {
            System.out.println(thridGoods.toString());
        }
    }

    @Override
    public Object findById(String id) {
        HuaJuGoods huaJuGoods = new HuaJuGoods();
        huaJuGoods.setCompanyId("0001");
        huaJuGoods.setCompanyName("华钜");
        huaJuGoods.setId("123123123");
        huaJuGoods.setUserName("炫彩服装");
        huaJuGoods.setPrice("1000");
        System.out.println("查询的数据是" + huaJuGoods.toString());
        return huaJuGoods;
    }
}
