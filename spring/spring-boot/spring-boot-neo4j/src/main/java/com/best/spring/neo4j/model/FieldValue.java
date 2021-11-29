package com.best.spring.neo4j.model;

import com.best.spring.neo4j.config.IdConfig;
import com.best.spring.neo4j.constants.NeoConsts;
import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

/**
 * 字段值
 */
@Node("FieldValue")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldValue {
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

    @Relationship(value = NeoConsts.R_ATTRIBUTES_VALUE_OF_ASSOCIATED_FIELD)
    private PreAssociatedField preAssociatedField;
}
