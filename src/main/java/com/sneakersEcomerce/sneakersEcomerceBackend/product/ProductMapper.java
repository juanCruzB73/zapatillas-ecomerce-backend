package com.sneakersEcomerce.sneakersEcomerceBackend.product;


import com.sneakersEcomerce.sneakersEcomerceBackend.discount.DiscountModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.discount.DiscountRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgDto;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.prices.PriceModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.prices.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductMapper {

    @Autowired
    PriceRepository priceRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImgRepository imgRepository;
    @Autowired
    DiscountRepository discountRepository;


    public ProductModel fromCreateToProduct(ProductCreateDTO productCreateDTO){
        ProductModel product = productCreateDTO.productId()
                .map(id->productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found")))
                .orElse(new ProductModel());
        product.setProductName(productCreateDTO.productName());

        Optional<Integer> discountIdOpt = productCreateDTO.discunt();

        if (discountIdOpt.isPresent()) {
            DiscountModel discount = discountRepository.findById(discountIdOpt.get())
                    .orElseThrow(() -> new RuntimeException("Discount not found"));
            product.setDiscount(discount);
        }
        product.setProductName(productCreateDTO.productName());

        product.setProductType(productCreateDTO.productType());

        product.setProductSubType(productCreateDTO.productSubType());

        product.setStock(productCreateDTO.stock());

        product.setColor(productCreateDTO.color());

        product.setDescription(productCreateDTO.description());

        product.setActive(productCreateDTO.active().orElse(true));

        product.setSex(productCreateDTO.sex());

        PriceModel price=priceRepository.findBySalePrice(productCreateDTO.price()).orElseGet(()-> {
                    PriceModel newPrice=new PriceModel();
                    newPrice.setSalePrice(productCreateDTO.price());
                    return priceRepository.save(newPrice);
                }
        );
        product.setPrice(price);

        product.setWeists(productCreateDTO.weist());

        if (product.getImgs() == null) {
            product.setImgs(new ArrayList<>());
        }

        product.getImgs().clear();

        if (productCreateDTO.img() != null && !productCreateDTO.img().isEmpty()) {
            for (Integer imgId : productCreateDTO.img()) {
                ImgModel img = imgRepository.findById(imgId).orElseThrow(() -> new RuntimeException("img not found"));
                product.getImgs().add(img);
            }
        }

        return product;
    }
}
