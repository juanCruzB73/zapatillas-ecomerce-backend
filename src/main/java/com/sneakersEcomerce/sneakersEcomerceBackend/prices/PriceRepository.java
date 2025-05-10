package com.sneakersEcomerce.sneakersEcomerceBackend.prices;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericRepository;

import java.util.Optional;

public interface PriceRepository extends GenericRepository<PriceModel,Integer> {
    Optional<PriceModel> findBySalePrice(Integer priceValue);
}
