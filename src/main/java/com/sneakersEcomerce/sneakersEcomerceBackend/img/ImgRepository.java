package com.sneakersEcomerce.sneakersEcomerceBackend.img;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericRepository;

import java.util.List;

public interface ImgRepository extends GenericRepository<ImgModel,Integer> {
    List<ImgModel> findByProductProductId(Integer productId);
}
