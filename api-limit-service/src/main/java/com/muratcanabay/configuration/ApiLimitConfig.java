package com.muratcanabay.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("api-limit")
public class ApiLimitConfig {

    private int min;
    private int max;

}
