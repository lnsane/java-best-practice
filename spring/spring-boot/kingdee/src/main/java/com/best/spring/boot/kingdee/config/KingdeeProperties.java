package com.best.spring.boot.kingdee.config;

import com.kingdee.bos.webapi.entity.IdentifyInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author CunLu Wang
 * @since 2022/9/14
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "kingdee.config")
public class KingdeeProperties extends IdentifyInfo {

}
