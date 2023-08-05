package com.meli.cupon.domain.model.entities

import spock.lang.Specification

class ItemSpec extends Specification {

    def "Item instance return IllegalArgumentException"() {
        when:
        new Item(new IdItem("MLA1"), valor)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == mensajeEsperado

        where:
        valor                  || mensajeEsperado
        BigDecimal.valueOf(0)  || "Invalid value."
        BigDecimal.valueOf(-1) || "Invalid value."

    }

    def "Valid item instance"() {
        given:
        def itemValue = BigDecimal.valueOf(100)

        when:
        def item = new Item(new IdItem("MLA1"), itemValue)

        then:
        with(item) {
            itemId() == new IdItem("MLA1")
            value() == BigDecimal.valueOf(100)
        }
    }
}
