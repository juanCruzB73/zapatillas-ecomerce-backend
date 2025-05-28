package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.catalog.CatalogModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.catalog.CatalogRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.prices.PriceModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.prices.PriceRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.productDetail.ProductDetailModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.productDetail.ProductDetailRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.weist.WeistModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.weist.WeistRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductMapper {
    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    WeistRepository weistRepository;
    @Autowired
    ImgRepository imgRepository;

    public ProductModel fromCreateToProduct(ProductCreateDTO productCreateDTO){
        ProductModel product = productCreateDTO.productId()
                .map(id->productRepository.findById(id).orElseThrow(()->new RuntimeException("user not found")))
                .orElse(new ProductModel());
        product.setProductName(productCreateDTO.productName());

        if(productCreateDTO.catalog()!=null){
            CatalogModel catalog = catalogRepository.findById(productCreateDTO.catalog())
                    .orElseThrow(() -> new EntityNotFoundException("Catalog not found with id " + productCreateDTO.catalog()));
            product.setCatalog(catalog);
        }


        product.setProductType(productCreateDTO.productType());

        Set<WeistModel>weists=new HashSet<>();
        if(productCreateDTO.weist().size() >0 && productCreateDTO.weist() != null) {
            for (Integer weistId:productCreateDTO.weist()){
                WeistModel weist = weistRepository.findById(weistId).orElseThrow(()->new RuntimeException("weist not found"));
                if(weist != null){
                    weists.add(weist);
                }
            }
        }
        product.setWeist(weists);

        product.setStock(productCreateDTO.stock());

        product.setColor(productCreateDTO.color());

        product.setState(productCreateDTO.state());

        product.setSex(productCreateDTO.sex());

        Set<ImgModel>imgs=new HashSet<>();
        if(productCreateDTO.img().size()>0 && productCreateDTO.img()!=null){
            for (Integer imgId:productCreateDTO.img()){
                ImgModel img=imgRepository.findById(imgId).orElseThrow(()->new RuntimeException("img not found"));
                if(img!=null){
                    imgs.add(img);
                }
            }
        }

        product.setImgs(imgs);

        PriceModel price=priceRepository.findBySalePrice(productCreateDTO.price()).orElseGet(()-> {
                    PriceModel newPrice=new PriceModel();
                    newPrice.setSalePrice(productCreateDTO.price());
                    return priceRepository.save(newPrice);
                }

        );
        product.setPrice(price);

        return product;
    }
}
