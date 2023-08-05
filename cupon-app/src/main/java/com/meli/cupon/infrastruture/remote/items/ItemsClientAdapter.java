package com.meli.cupon.infrastruture.remote.items;

import com.meli.cupon.application.spi.ItemsClient;
import com.meli.cupon.domain.model.entities.IdItem;
import com.meli.cupon.domain.model.entities.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.RoundingMode;

@Component
@Slf4j
public class ItemsClientAdapter implements ItemsClient {

    private final WebClient webClient;

    public ItemsClientAdapter(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Item> getItem(IdItem idItem) {
        final String MELI_HOST = "https://www.foo.com";
        return webClient.get()
            .uri(MELI_HOST + "/items/" + idItem.valor())
            .retrieve()
            .onStatus(
                HttpStatus::is4xxClientError,
                error ->
                    error.bodyToMono(String.class)
                        .map(body -> {
                            log.warn("El servicio retorno: {} {}",
                                error.statusCode(), body);
                            return new HttpClientErrorException(error.statusCode(), body);
                        }))
            .bodyToMono(ItemDto.class)
            .map(dto -> toItem(idItem, dto))
            .doOnError(t -> log.warn("No fue posible obtener el item con identificador: {}, error: {}",
                idItem.valor(), t.getMessage()));
    }

    private Item toItem(IdItem idItem, ItemDto dto) {
        final var itemPrice = dto.price.setScale(2, RoundingMode.HALF_UP);
        return new Item(idItem, itemPrice);
    }
}
