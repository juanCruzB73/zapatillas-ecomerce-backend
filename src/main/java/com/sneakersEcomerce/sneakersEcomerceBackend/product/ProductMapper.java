package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.catalog.CatalogModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.catalog.CatalogRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.productDetail.ProductDetailModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.productDetail.ProductDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductRepository productRepository;

    public ProductModel fromCreateToProduct(ProductCreateDTO productCreateDTO){
        ProductModel product = productCreateDTO.productId()
                .map(id->productRepository.findById(id).orElseThrow(()->new RuntimeException("user not found")))
                .orElse(new ProductModel());
        product.setProductName(productCreateDTO.productName());

        CatalogModel catalog = catalogRepository.findById(productCreateDTO.catalog())
                .orElseThrow(() -> new EntityNotFoundException("Catalog not found with id " + productCreateDTO.catalog()));
        product.setCatalog(catalog);

        ProductDetailModel productDetail = productDetailRepository.findById(productCreateDTO.productDetail()).orElse(new ProductDetailModel());
        product.setProductDetail(productDetail);

        product.setProductType(productCreateDTO.productType());

        return product;
    }
}
