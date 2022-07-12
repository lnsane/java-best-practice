package com.ds.spring.boot.ds.data.source;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class OrderComplexKeysShardingAlgorithm2 implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        System.out.println(1);

        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(Long.parseLong(shardingValue.getValue()) % 2 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}
