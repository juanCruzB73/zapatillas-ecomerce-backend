package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgRepository;
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
    @Autowired
    ImgRepository imgRepository;



    public List<ProductModel> getAllWithImg(){
        List<ProductModel>productsFromDB=productRepository.findAll();
        List<ProductModel>productsWithImg=new ArrayList<>();
        for(ProductModel product:productsFromDB){
            List<ImgModel> imgs = imgRepository.findByProductProductId(product.getProductId());
            product.setImgs(imgs);
        }
        return productsFromDB;
    }

    public ProductService(ProductRepository productRepository){
        super(productRepository);
    }

    public ProductModel save(@RequestBody ProductCreateDTO entity) {
        try {
            var product=productMapper.fromCreateToProduct(entity);
            if (product.getImgs() != null) {
                for (ImgModel img : product.getImgs()) {
                    img.setProduct(product);
                }
            }

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
    public List<ProductModel> getActiveProducts() {
        return productRepository.findByActiveTrue();
    }
}
