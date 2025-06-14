package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends GenericController<ProductModel,Integer> {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getAll")
    public List<ProductModel>getAllWithImg(){
        return productService.getAllWithImg();
    }

    @GetMapping("gender")
    public List<ProductModel>getProductBySex(@RequestParam String sex){
        return productService.getProductBySex(sex);
    }

    @GetMapping("productType")
    public List<ProductModel>getProductByType(@RequestParam String type){
        return productService.getProductsByType(type);
    }

    @GetMapping("/sex/{sex}/type/{type}")
    public List<ProductModel> getBySexAndType(@PathVariable String sex, @PathVariable String type) {
        return productRepository.findBySexAndProductType(sex, type).orElse(List.of());
    }

    @GetMapping("/sex/{sex}/subtype/{subtype}")
    public List<ProductModel> getBySexAndSubType(@PathVariable String sex, @PathVariable String subtype) {
        return productRepository.findBySexAndProductSubType(sex, subtype).orElse(List.of());
    }

    @GetMapping("/active")
    public List<ProductModel> getActiveProducts() {
        return productService.getActiveProducts();
    }

    public ProductController(ProductService productService){
        super(productService);
    }

    @PostMapping("/create")
    public ProductModel createWithDTO(@RequestBody ProductCreateDTO dto) {
        return productService.save(dto);
    }

    @PutMapping("/update/{productId}")
    public ProductModel updateWithDTO(@RequestBody ProductCreateDTO dto) {
        return productService.save(dto);
    }
}
