package com.best.spring.neo4j.model;

import com.best.spring.neo4j.config.IdConfig;
import com.best.spring.neo4j.constants.NeoConsts;
import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

/**
 * 平台
 */
@Node("Platform")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Platform {
    @Id
    @GeneratedValue(value = IdConfig.class)
    private String id;
    /**
     * 平台号 0 -> 亚马逊
     */
    @Property
    @NonNull
    private Integer platformNumber;
    /**
     * 平台名
     */
    @Property
    @NonNull
    private String platformName;
    /**
     * 关联 国家
     */
    @Relationship(type = NeoConsts.R_PLATFORM_OF_COUNTRY)
    private Country country;
}
