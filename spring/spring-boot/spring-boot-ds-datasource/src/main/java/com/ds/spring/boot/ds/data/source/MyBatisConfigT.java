package com.ds.spring.boot.ds.data.source;

import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.ComplexShardingStrategyConfiguration;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class MyBatisConfigT extends MyBatisConfig{
    @Override
    public ShardingRuleConfiguration createDB1shardingRuleConfig() {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.setBindingTableGroups(Collections.singletonList("user"));
        TableRuleConfiguration result = new TableRuleConfiguration("user","ds$->{0..1}.user_$->{0..2}");
        result.setTableShardingStrategyConfig(new ComplexShardingStrategyConfiguration("name",new TblRangeShardAlgo()));
        shardingRuleConfig.getTableRuleConfigs().add(result);
        return shardingRuleConfig;
    }
}
