package com.best.spring.boot.elastic.search.config;

/**
 * @author 王存露
 */
public interface EsIndex {
    /**
     * 所以index都使用该类型名称
     */
    String DEFAULT_TYPE_NAME = "_doc";

    /**
     * 索引名称
     */
    String INDEX_NAME_MERCURY = "goods";
}
