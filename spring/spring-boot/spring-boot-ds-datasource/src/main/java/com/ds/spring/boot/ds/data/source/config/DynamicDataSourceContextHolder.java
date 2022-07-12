package com.ds.spring.boot.ds.data.source.config;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.springframework.stereotype.Component;

@Component
public class DynamicDataSourceContextHolder {
    private static final TransmittableThreadLocal<String> CONTEXT_HOLDER = new TransmittableThreadLocal<String>();

    // 设置数据源
    public static void setDataSourceName(String dataSourceType) {
        CONTEXT_HOLDER.set(dataSourceType);
    }

    // 获取数据源
    public static String getDataSourceName() {

        return CONTEXT_HOLDER.get();

    }

    // 获取数据源
    public static void clear() {
        CONTEXT_HOLDER.remove();
    }
}
