package com.best.spring.neo4j.model;

import com.best.spring.neo4j.config.IdConfig;
import com.best.spring.neo4j.constants.NeoConsts;
import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

/**
 * 类目
 */
@Node("Category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(value = IdConfig.class)
    private String id;
    /**
     * 关联类目id
     */
    @Property
    @NonNull
    private String categoryId;
    /**
     * 关联类目名
     */
    @Property
    @NonNull
    private String categoryName;
    /**
     * 关联属性名
     */
    @Relationship(type = NeoConsts.R_LAST_CATEGORY_OF_ADDITIONAL_ATTRIBUTES)
    private Field field;
}
