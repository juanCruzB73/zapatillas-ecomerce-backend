package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import java.util.List;
import java.util.Optional;

public record OrderDTO(
        Optional<Integer>orderId,
        String date,
        Integer address,
        List<Integer>orderDetails,
        Integer user
) {}
