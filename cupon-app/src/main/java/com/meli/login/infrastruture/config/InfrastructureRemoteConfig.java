package com.meli.login.infrastruture.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureRemoteConfig {

//    @Bean
//    ItemsClient itemsClient(
//        @Qualifier("routingResilientHttpClient") Service<Request, Response> routingResilientHttpClient,
//        ObjectMapper objectMapper) {
//        HttpClientErrorsResponseFilter httpClientErrorsResponseFilter =
//            new HttpClientErrorsResponseFilter();
//        Service<Request, Response> webService = httpClientErrorsResponseFilter.andThen(routingResilientHttpClient)
//        return new ItemsClientAdapter(webService, objectMapper);
//    }

//    @Bean
//    ItemsClient itemsClient(
//        @Qualifier("routingResilientHttpClient") Service<Request, Response> routingResilientHttpClient,
//        ObjectMapper objectMapper) {
//        HttpClientErrorsResponseFilter httpClientErrorsResponseFilter =
//            new HttpClientErrorsResponseFilter();
//        JsonDes
//        Service<Request, ItemDto> servicioWeb = httpClientErrorsResponseFilter
//            .andThen(routingResilientHttpClient);
//        return new ItemsClientAdapter()
//    }
}
