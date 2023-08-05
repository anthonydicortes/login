package com.meli.cupon.infrastruture.config;

import org.springframework.context.annotation.Configuration;


/**
 * This finable config was obtained from:
 * https://medium.com/javarevisited/how-to-connect-to-a-restapi-microservice-with-twitters-finagle-client-c1a76cfb528c
 */
@Configuration
public class FinagleConfig {

//    For finagle
//    @Bean
//    Service<Request, Response> httpClient(
//        @Value("${server.port:8080}") int port,
//        @Value("${global-timeout:5000}") int globalTimeout,
//        @Value("${request-timeout:1000}") int requestTimeout) {
//
//        Duration timeoutDuration = Duration.fromMilliseconds(globalTimeout);
//        TimeoutFilter<Request, Response> timeoutFilter = new TimeoutFilter<>(
//            timeoutDuration,
//            new GlobalRequestTimeoutException(timeoutDuration),
//            DefaultTimer.getInstance()
//        );
//
//        var backoff = Backoff.exponentialJittered(Duration.fromMilliseconds(100), Duration.fromMilliseconds(30_000));
//        RetryExceptionsFilter<Request, Response> rt = new RetryExceptionsFilter<>(
//            RetryPolicy.backoffJava(Backoff
//                    .toJava(backoff),
//                RetryPolicy.TimeoutAndWriteExceptionsOnly()), HighResTimer.Default(), NullStatsReceiver.get());
//
//        HttpClientErrorsResponseFilter httpClientErrorsResponseFilter =
//            new HttpClientErrorsResponseFilter();
//
//        RetryBudget budget = RetryBudgets.newRetryBudget(Duration.fromMilliseconds(1000), 10, 1);
//        Http.Client client = Http.client()
//            .withRetryBudget(budget)
//            .withRetryBackoff(backoff)
//            .withRequestTimeout(Duration.fromMilliseconds(requestTimeout));
//
//        return new LogFilter()
//            .andThen(timeoutFilter)
//            .andThen(rt)
//            .andThen(httpClientErrorsResponseFilter)
//            .andThen(client.newService(":" + port));
//
//    }
}

