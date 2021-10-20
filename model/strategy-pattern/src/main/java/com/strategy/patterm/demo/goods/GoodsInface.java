package com.strategy.patterm.demo.goods;

import com.strategy.patterm.demo.bean.BaseGoods;

import java.util.List;

public interface GoodsInface {
    /**
     * 商品保存
     */
    void save(List<? extends BaseGoods> c);

    Object findById(String id);
}
