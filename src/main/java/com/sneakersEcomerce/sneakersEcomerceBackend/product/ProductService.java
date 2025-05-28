package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends GenericServiceImpl<ProductModel,Integer> {

    @Autowired
    ProductMapper productMapper;
    @Autowired ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        super(productRepository);
    }

    public ProductModel save(@RequestBody ProductCreateDTO entity) {
        try {
            var product=productMapper.fromCreateToProduct(entity);
            return super.save(product);
        }catch (Exception e){
            System.out.println(e);
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

    public List<ProductModel> getProductBySex(String sex) {
        try {
            List<ProductModel>allProducts=productRepository.findBySex(sex).orElseThrow();
            return allProducts;
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
    public List<ProductModel> getProductsByType(String type) {
        try {
            List<ProductModel>allProducts=productRepository.findByProductType(type).orElseThrow();
            return allProducts;
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
}
