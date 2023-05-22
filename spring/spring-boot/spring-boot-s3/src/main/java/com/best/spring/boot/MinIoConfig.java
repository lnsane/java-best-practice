package com.best.spring.boot;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hecan
 */
@Configuration
public class MinIoConfig {


    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint("https://s3.ap-southeast-1.amazonaws.com").credentials("AKIA3JLSMPMWMU7P4NFE", "XIJPyp5aSTAXjoduAbsvOrcaXmmrs3FbHcC0Fe+y").build();
    }
}
