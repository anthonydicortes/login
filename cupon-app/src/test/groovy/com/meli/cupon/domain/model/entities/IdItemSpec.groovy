package com.meli.cupon.domain.model.entities

import spock.lang.Specification

class IdItemSpec extends Specification {

    def "Instancia de IdItem retorna IllegalArgumentException"() {
        when:
        new IdItem(valor)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == mensajeEsperado

        where:
        valor || mensajeEsperado
        null  || "Invalid value."
        ""    || "Invalid value."

    }

    def "Instancia de IdItem es valida"() {
        given:
        def valorIdItem = "MLA1"

        when:
        def idItem = new IdItem(valorIdItem)

        then:
        idItem.valor() == "MLA1"
    }
}
