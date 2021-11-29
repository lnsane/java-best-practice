package com.best.spring.neo4j.model;

import com.best.spring.neo4j.config.IdConfig;
import com.best.spring.neo4j.constants.NeoConsts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

/**
 * 关联字段
 */
@Node("AssociatedField")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssociatedField {
    @Id
    @GeneratedValue(value = IdConfig.class)
    private String id;
    /**
     * 关联字段名 中文
     */
    @Property
    private String attributesCnName;
    /**
     * 关联字段名 英文
     */
    @Property
    private String attributesEnName;

    @Relationship(value = NeoConsts.R_ASSOCIATED_FIELD_OF_ASSOCIATED_VALUE)
    private AssociatedFieldValue associatedFieldValue;
}
