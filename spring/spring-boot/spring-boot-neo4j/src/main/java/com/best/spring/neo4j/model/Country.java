package com.best.spring.neo4j.model;

import com.best.spring.neo4j.config.IdConfig;
import com.best.spring.neo4j.constants.NeoConsts;
import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

/**
 * 国家
 */
@Node("Country")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(value = IdConfig.class)
    private String id;
    /**
     * 国家英文名
     */
    @Property
    @NonNull
    private String countryEnName;
    /**
     * 国家中文名
     */
    @Property
    @NonNull
    private String countryCnName;
    /**
     * 关联类目
     */
    @Relationship(type = NeoConsts.R_COUNTRY_OF_LAST_CATEGORY)
    private Category associatedCategory;
}
