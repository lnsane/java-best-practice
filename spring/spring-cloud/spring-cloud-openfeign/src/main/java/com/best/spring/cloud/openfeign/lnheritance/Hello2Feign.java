package com.best.spring.cloud.openfeign.lnheritance;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lnsane
 */
@FeignClient(name = "${spring.application.name}", url = "localhost:${server.port}")
public interface Hello2Feign extends Hello {

}
