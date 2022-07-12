package com.ds.spring.boot.ds.data.source;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.ds.spring.boot.ds.data.source.config.ShardingConfig;
import com.ds.spring.boot.ds.data.source.config.DynamicDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@AutoConfigureBefore(value = DataSourceAutoConfiguration.class, name = "com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure")
public abstract class MyBatisConfig {

    @Bean(ShardingConfig.SHARDING)
    @ConditionalOnMissingBean
    public DataSource basicDataSource(ShardingConfig shardingConfig) throws SQLException {
        Map<String, DataSource> db1DataSourceMap = new HashMap<>(6);
        if (shardingConfig.getDatasource() == null) {
            throw new RuntimeException("spring.datasource.sharding-jdbc.datasource 未配置");
        }
        shardingConfig.getDatasource().forEach((name, jdbcConfig) -> {
            try {
                db1DataSourceMap.put(name, createDataSource(jdbcConfig));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        Map<Object, Object> targetDataSources = new HashMap<>(3);
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(db1DataSourceMap, createDB1shardingRuleConfig(), properties(shardingConfig.getShowSql()));
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        targetDataSources.put(ShardingConfig.SHARDING, dataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    private Properties properties(Boolean showSql) {
        Properties p = new Properties();
        p.setProperty("sql.show", showSql.toString());
//        p.setProperty("check.table.metadata.enabled",Boolean.TRUE.toString());
        return p;
    }


//    private ShardingRuleConfiguration createDB1AccountShardingRuleConfig(){
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
    // shardingRuleConfig.setDefaultTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("account_id","sharding-jdbc0.account_${0..4}"));
//        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("account_id",new AccountShardingStrategy()));
    //如果有多个数据表需要分表，依次添加到这里
//        shardingRuleConfig.setBindingTableGroups(Arrays.asList("account"));
//        shardingRuleConfig.getTableRuleConfigs().addAll(Arrays.asList(getDB1AccountTableRuleConfiguration()));
//        return shardingRuleConfig;
//    }

    //分库分表
    public abstract ShardingRuleConfiguration createDB1shardingRuleConfig();
//    {
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
////        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id",new CustomShardingTableAlgorithm()));
//        //第一种
////        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", " sharding-jdbc${user_id % 2}"));
//        //第二种
////        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new ComplexShardingStrategyConfiguration("id",new TblRangeShardAlgo()));
//        //如果有多个数据表需要分表，依次添加到这里
//        shardingRuleConfig.setBindingTableGroups(Arrays.asList("user"));
//        shardingRuleConfig.getTableRuleConfigs().addAll(Arrays.asList(getDB1OrderTableRuleConfiguration()));
//        return shardingRuleConfig;
//    }

    /**
     * KeyGeneratorConfiguration的构造参数type 自增列值生成器类型，可自定义或选择内置类型：SNOWFLAKE/UUID
     *
     * @return
     */
//    @Bean
//    public abstract TableRuleConfiguration getDB1OrderTableRuleConfiguration();
//    {
//        TableRuleConfiguration result = new TableRuleConfiguration("user","ds$->{0..1}.user_$->{0..2}");
//        result.setTableShardingStrategyConfig(new ComplexShardingStrategyConfiguration("name",new TblRangeShardAlgo()));
////        result.setKeyGeneratorConfig(new KeyGeneratorConfiguration("SNOWFLAKE","id"));
//        return result;
//    }

//    @Bean
//    public TableRuleConfiguration getDB1AccountTableRuleConfiguration() {
//        TableRuleConfiguration result = new TableRuleConfiguration("account","sharding-jdbc0.account_${0..4}");
//        result.setKeyGeneratorConfig(new KeyGeneratorConfiguration("SNOWFLAKE","id"));
//        return result;
//    }

//    @Bean
//    @Qualifier("sqlSessionFactory")
//    public SqlSessionFactoryBean sqlSessionFactory(@Autowired DataSource dataSource) throws IOException {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        // configuration.addInterceptor(new PageInterceptor());
//        sqlSessionFactoryBean.setConfiguration(configuration);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//        return sqlSessionFactoryBean;
//    }

//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
//        return sqlSessionTemplate;
//    }
    public DataSource createDataSource(ShardingConfig.JdbcConfig jdbcConfig) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcConfig.getDriverClassName());
        dataSource.setUrl(jdbcConfig.getUrl());
        dataSource.setUsername(jdbcConfig.getUsername());
        dataSource.setPassword(jdbcConfig.getPassword());
        dataSource.setMaxActive(64);
        dataSource.setMinIdle(16);
        dataSource.setMaxWait(60000);
        return dataSource;
    }
//
//
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
//        return interceptor;
//    }

//    @Override
//
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        DataSource bean = applicationContext.getBean(DataSource.class);
//        DynamicRoutingDataSource bean1 = (DynamicRoutingDataSource) bean;
//        System.out.println(bean);
//
//    }
}
