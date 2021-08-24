package com.best.spring.neo4j.constants;

public interface NeoConsts {
    /**
     * 平台 关联 国家
     */
    String R_PLATFORM_OF_COUNTRY = "R_PLATFORM_OF_COUNTRY";

    /**
     * 国家 关联 类目
     */
    String R_COUNTRY_OF_LAST_CATEGORY = "R_COUNTRY_OF_LAST_CATEGORY";

    /**
     * 类目 关联 附加属性
     */
    String R_LAST_CATEGORY_OF_ADDITIONAL_ATTRIBUTES = "R_LAST_CATEGORY_OF_ADDITIONAL_ATTRIBUTES";

    /**
     * 属性名 关联 属性值
     */
    String R_FIELD_OF_ATTRIBUTES_VALUE = "R_FIELD_OF_ATTRIBUTES_VALUE";

    /**
     * 属性值 关联 关联字段
     */
    String R_ATTRIBUTES_VALUE_OF_ASSOCIATED_FIELD = "R_ATTRIBUTES_VALUE_OF_ASSOCIATED";

    /**
     * 关联字段 关联 关联字段值
     */
    String R_ASSOCIATED_FIELD_OF_ASSOCIATED_VALUE = "R_ASSOCIATED_FIELD_OF_ASSOCIATED_VALUE";
}
