package com.sneakersEcomerce.sneakersEcomerceBackend.productDetail;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productDetail")
public class ProductDetailController extends GenericController<ProductDetailModel,Integer> {

    public ProductDetailController(ProductDetailService productDetailService){
        super(productDetailService);
    }
}
