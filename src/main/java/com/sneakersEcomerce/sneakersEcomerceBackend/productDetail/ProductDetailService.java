package com.sneakersEcomerce.sneakersEcomerceBackend.productDetail;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService extends GenericServiceImpl<ProductDetailModel,Integer> {
    public ProductDetailService(ProductDetailRepository productDetailRepository){
        super(productDetailRepository);
    }
}
