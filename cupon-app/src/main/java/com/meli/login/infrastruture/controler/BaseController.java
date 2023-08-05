package com.meli.login.infrastruture.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import reactor.core.publisher.Mono;

@RestController
public class BaseController {

    public BaseController() {
    }

    @GetMapping("/base")
    public Mono<ResponseEntity<String>> getBase() {
        return Mono.defer(() -> Mono.just("Base request"))
            .map(ResponseEntity::ok)
            .onErrorResume(t -> {
                if (t instanceof HttpClientErrorException)
                    return Mono.just(ResponseEntity.status(((HttpClientErrorException) t).getStatusCode()).build());
                else return Mono.just(ResponseEntity.internalServerError().build());
            });
    }

}
