package org.sid.gatewaysc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayScApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayScApplication.class, args);
    }
    
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
//                .route(r->r.path("/customers/**").uri("http://localhost:9081"))  sans Eureka discovery
//                .route(r->r.path("/products/**").uri("http://localhost:9082"))
                .route(r->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route(r->r.path("/products/**").uri("lb://INVENTORY-SC"))
                .build();
    }
//    @Bean
//    public DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
//                                                               DiscoveryLocatorProperties dlp){
//        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
//    } 
//    afin d'appeller les services avec leur nom dans les paths au lieu d'appeller http://localhost:9999/products
//    tu va appeller http://localhost:9999/INVENTORY-SC/products  ps: n'oublie pas d'eliminer bean de metpode routes

    

}