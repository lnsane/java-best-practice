package com.best.spring.neo4j.model;

import com.best.spring.neo4j.config.IdConfig;
import com.best.spring.neo4j.constants.NeoConsts;
import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

/**
 * 字段
 */
@Node("Field")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    @Id
    @GeneratedValue(value = IdConfig.class)
    private String id;
    /**
     * 属性名
     */
    @Property
    @NonNull
    private String fieldName;
    /**
     * 关联属性值
     */
    @Relationship(value = NeoConsts.R_FIELD_OF_ATTRIBUTES_VALUE)
    private List<FieldValue> fieldValue;
}
