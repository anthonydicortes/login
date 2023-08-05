package com.meli.login.domain.model.entities;

import java.math.BigDecimal;

public record Item(IdItem itemId, BigDecimal value) {

    public Item {
        if (value.signum() <= 0) throw new IllegalArgumentException("Invalid value.");
    }
}