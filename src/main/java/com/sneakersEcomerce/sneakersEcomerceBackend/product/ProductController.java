package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController extends GenericController<ProductModel,Integer> {

    @Autowired
    ProductService productService;

    @GetMapping("gender")
    public List<ProductModel>getProductBySex(@RequestParam String sex){
        return productService.getProductBySex(sex);
    }
    @GetMapping("productType")
    public List<ProductModel>getProductByType(@RequestParam String type){
        return productService.getProductsByType(type);
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
