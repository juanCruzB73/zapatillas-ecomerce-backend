package com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail;

import java.util.Optional;

public record OrderDetailDTO(
     Optional<Integer>orderDetailId,
     Integer amount,
     Integer product
) {
}
