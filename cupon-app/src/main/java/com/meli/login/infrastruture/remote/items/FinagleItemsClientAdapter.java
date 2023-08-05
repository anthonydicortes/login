package com.meli.login.infrastruture.remote.items;

import com.meli.login.application.spi.ItemsClient;
import com.meli.login.domain.model.entities.IdItem;
import com.meli.login.domain.model.entities.Item;
import reactor.core.publisher.Mono;

public class FinagleItemsClientAdapter implements ItemsClient {


//    for finagle proposes
//    private final Service<Request, Response> httpClient;

//      private final ObjectMapper mapper;


    @Override
    public Mono<Item> getItem(IdItem idItem) {
        return null;
    }

//    Intencianalmente dejado como comentario
//        @Override
//    public Mono<Item> obtenerItem(IdItem idItem) {
//        Request solicitud = Request.apply(Method.Get(), MELI_HOST + "/items/" + idItem.value());
//        Future<Response> respuesta = httpClient.apply(solicitud);
//
//        return Mono.fromFuture(respuesta.toCompletableFuture())
//            .flatMap(r -> {
//                Response res = (Response) r;
//                LOG.debug("Obtener items - received: {}, body: {}", res, res.contentString());
//                if (res.status() != Status.Ok()) {
//                    final var mensajeDeError = String.format("El servicio retorno %s %s: %s", res.status(),
//                        res, res.getContentString());
//                    Mono.error(new IllegalStateException(mensajeDeError));
//                }
//                try {
//                    final var dto = mapper.readValue(res.contentString(), ItemDto.class);
//                    return Mono.just(dto);
//                } catch (JsonProcessingException e) {
//                    return Mono.error(e);
//                }
//            }).doOnError(t -> LOG.warn("No fue posible obtener el item con identificador: {}, error: {}",
//                idItem.value(), t.getMessage()))
//            .map(dto -> toItem(idItem, dto));
//    }
}
