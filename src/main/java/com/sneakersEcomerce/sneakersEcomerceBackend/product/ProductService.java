package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericServiceImpl<ProductModel,Integer> {
    public ProductService(ProductRepository productRepository){
        super(productRepository);
    }
}
