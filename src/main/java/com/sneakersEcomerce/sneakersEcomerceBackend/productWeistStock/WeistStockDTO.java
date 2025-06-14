package com.sneakersEcomerce.sneakersEcomerceBackend.productWeistStock;

import java.util.Optional;

public record WeistStockDTO(Integer weistId, Integer stock, Optional<Boolean>active) {
}
