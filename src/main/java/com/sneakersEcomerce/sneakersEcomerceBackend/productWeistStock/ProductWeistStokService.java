package com.sneakersEcomerce.sneakersEcomerceBackend.productWeistStock;

import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.weist.WeistModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductWeistStokService {

    @Autowired
    ProductWeistStockRepository productWeistStockRepository;

    public Optional<WeistStockDTO> getStockByProductAndWeist(Integer productId, Integer weistId) {
        return productWeistStockRepository
                .findByProduct_ProductIdAndWeist_Id(productId, weistId)
                .map(stock -> new WeistStockDTO(
                        stock.getWeist().getId(),
                        stock.getStock(),
                        Optional.ofNullable(stock.getActive())
                ));
    }

    public ProductWeistStockModel addStock(Integer productId, WeistStockDTO dto) {
        // Check if already exists
        Optional<ProductWeistStockModel> existing = productWeistStockRepository.findByProduct_ProductIdAndWeist_Id(productId, dto.weistId());

        if (existing.isPresent()) {
            throw new IllegalArgumentException("Stock for product and weist already exists");
        }

        // You may want to load the full ProductModel and WeistModel from DB here instead of creating new with only ID
        ProductModel product = new ProductModel();
        product.setProductId(productId);

        WeistModel weist = new WeistModel();
        weist.setId(dto.weistId());

        ProductWeistStockModel newStock = ProductWeistStockModel.builder()
                .product(product)
                .weist(weist)
                .stock(dto.stock())
                .active(true)
                .build();

        ProductWeistStockModel saved = productWeistStockRepository.save(newStock);
        return saved;
    }

    public ProductWeistStockModel updateStock(Integer productId, WeistStockDTO dto) {
        ProductWeistStockModel existing = productWeistStockRepository
                .findByProduct_ProductIdAndWeist_Id(productId, dto.weistId())
                .orElseThrow(() -> new EntityNotFoundException("Stock not found for product and weist"));
        dto.active().ifPresent(existing::setActive);
        existing.setStock(dto.stock());

         ProductWeistStockModel updated = productWeistStockRepository.save(existing);
        return updated;

    }
}


