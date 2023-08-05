package com.meli.login.domain.model.entities;

import org.springframework.util.Assert;

public record IdItem(String valor) {

    public IdItem {
        Assert.hasText(valor, "Invalid value.");
    }
}
