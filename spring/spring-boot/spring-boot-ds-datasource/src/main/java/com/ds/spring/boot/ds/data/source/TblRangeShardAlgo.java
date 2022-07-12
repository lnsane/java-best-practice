package com.ds.spring.boot.ds.data.source;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TblRangeShardAlgo implements ComplexKeysShardingAlgorithm<String> {

    /**
     * 订单id列名
     */
    private static final String COLUMN_ORDER_ID = "order_id";
    /**
     * 客户id列名
     */
    private static final String COLUMN_CUSTOMER_ID = "customer_id";

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<String> shardingValue) {
        return availableTargetNames;
    }

    /**
     * 转换成String
     */
    private List<String> ids2String(Collection<?> ids) {
        List<String> result = new ArrayList<>(ids.size());
        ids.forEach(id -> result.add(Objects.toString(id)));
        return result;
    }
}