package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService extends GenericServiceImpl<ProductModel,Integer> {

    @Autowired
    ProductMapper productMapper;

    public ProductService(ProductRepository productRepository){
        super(productRepository);
    }

    public ProductModel save(@RequestBody ProductCreateDTO entity) {
        try {
            var product=productMapper.fromCreateToProduct(entity);
            return super.save(product);
        }catch (Exception e){
            return new ProductModel();
        }

    }
    public ProductModel update(@RequestBody ProductCreateDTO entity) {
        try {
            var product=productMapper.fromCreateToProduct(entity);
            return super.save(product);
        }catch (Exception e){
            return new ProductModel();
        }

    }
}
