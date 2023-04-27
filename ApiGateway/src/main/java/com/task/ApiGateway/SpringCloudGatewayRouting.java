package com.task.ApiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder)
    {
        return (RouteLocator) builder.routes()
                .route("Employee-Service",r-> r.path("/emp/**").uri("lb://Employee-Service"))
                .route("Department-Service",r-> r.path("/dept/**").uri("lb://Department-Service"))
                .build();
    }
}
