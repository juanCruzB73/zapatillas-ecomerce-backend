package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgDto;
import com.sneakersEcomerce.sneakersEcomerceBackend.productWeistStock.ProductWeistStockModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.productWeistStock.WeistStockDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public record ProductCreateDTO(
        Optional<Integer> productId,
        String productName,
        String productType,
        String productSubType,
        Set<String> weist,
        String description,
        Integer stock,
        String color,
        List<Integer> img,
        String sex,
        Integer price,
        Optional<Integer>discunt,
        Optional<Boolean>active,
        List<ProductWeistStockModel> weistStocks
) {}

