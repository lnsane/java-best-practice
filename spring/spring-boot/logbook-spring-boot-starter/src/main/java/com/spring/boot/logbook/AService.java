package com.spring.boot.logbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author CunLu Wang
 * @since 2023/7/5
 */
@Component
public class AService {
    Logger logger = LoggerFactory.getLogger(AService.class);
    public void hello(){
        logger.info("你好");
    }
}
