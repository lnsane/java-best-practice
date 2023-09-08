package com.best.spring.cloud.zipkin.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lnsane
 */
@FeignClient(name = "opefeign-demo", url = "localhost:9091")
public interface Hello2Feign extends Hello {

}
