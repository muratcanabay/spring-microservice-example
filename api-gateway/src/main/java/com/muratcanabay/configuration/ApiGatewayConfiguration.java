package com.muratcanabay.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    /**
     * {@link RouteLocator} works default as following: {@code builder.routes().build()}
     *
     * @return {@link RouteLocator}
     */
    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
                .route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
                .route(p -> p.path("/sample-api/**").uri("lb://circuit-breaker"))
                .build();
    }
}
