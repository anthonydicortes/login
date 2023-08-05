package com.meli.login.application.spi;

import com.meli.login.domain.model.entities.IdItem;
import com.meli.login.domain.model.entities.Item;
import reactor.core.publisher.Mono;

public interface ItemsClient {

    /**
     * Retorna la informacion de un item
     *
     * @param idItem identificador del item
     * @return la informacion de un item
     */
    Mono<Item> getItem(IdItem idItem);
}
