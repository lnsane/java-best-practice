package com.best.spring.neo4j.config;

import cn.hutool.core.util.IdUtil;
import org.springframework.data.neo4j.core.schema.IdGenerator;

public final class IdConfig implements IdGenerator<String> {
    @Override
    public String generateId(String primaryLabel, Object entity) {
        return IdUtil.simpleUUID();
    }
}
