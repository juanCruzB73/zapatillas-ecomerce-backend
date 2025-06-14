package com.sneakersEcomerce.sneakersEcomerceBackend.productWeistStock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/{productId}/stocks")
public class ProductWeistStockController {

    @Autowired
    private ProductWeistStokService productWeistStockService;

    @PostMapping
    public ProductWeistStockModel addStock(
            @PathVariable Integer productId,
            @RequestBody WeistStockDTO dto
    ) {
        return productWeistStockService.addStock(productId, dto);
    }

    @PutMapping
    public ProductWeistStockModel updateStock(
            @PathVariable Integer productId,
            @RequestBody WeistStockDTO dto
    ) {
        return productWeistStockService.updateStock(productId, dto);
    }

    @GetMapping("/{weistId}")
    public WeistStockDTO getStock(
            @PathVariable Integer productId,
            @PathVariable Integer weistId
    ) {
        return productWeistStockService.getStockByProductAndWeist(productId, weistId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }
}
