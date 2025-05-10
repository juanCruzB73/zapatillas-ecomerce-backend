package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public record ProductCreateDTO(
        Optional<Integer> productId,
        String productName,
        Integer catalog,
        String productType,
        Set<Integer> weist,
        Integer stock,
        String color,
        Boolean state,
        String img,
        String sex,
        Integer price
) {}

