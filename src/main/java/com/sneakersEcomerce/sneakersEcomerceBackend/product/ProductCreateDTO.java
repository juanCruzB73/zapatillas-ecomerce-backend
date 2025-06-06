package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public record ProductCreateDTO(
        Optional<Integer> productId,
        String productName,
        Integer catalog,
        String productType,
        Set<String> weist,
        Integer stock,
        String color,
        Boolean state,
        Set<Integer> img,
        String sex,
        Integer price,
        Optional<Integer>discunt
) {}

