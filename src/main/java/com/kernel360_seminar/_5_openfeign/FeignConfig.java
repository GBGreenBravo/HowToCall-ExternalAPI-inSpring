package com.kernel360_seminar._5_openfeign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.kernel360_seminar")
public class FeignConfig {
}
