package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import java.util.Optional;

public record ProductCreateDTO(
        Optional<Integer> productId,
        String productName,
        Integer catalog,
        Integer productDetail,
        String productType
) {}

