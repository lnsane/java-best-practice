package com.best.spring.neo4j.model;

import com.best.spring.neo4j.config.IdConfig;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * 字段值
 */
@Node("AssociatedFieldValue")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssociatedFieldValue {
    @Id
    @GeneratedValue(value = IdConfig.class)
    private String id;
    /**
     * 属性值 英文
     */
    @Property
    @NonNull
    private String enValue;
    /**
     * 属性值 中文
     */
    @Property
    private String cnValue;
}
