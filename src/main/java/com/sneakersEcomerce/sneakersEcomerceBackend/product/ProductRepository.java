package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends GenericRepository<ProductModel,Integer> {
    Optional<List<ProductModel>> findByProductType(String productType);
    Optional<List<ProductModel>> findBySex(String sex);
}
