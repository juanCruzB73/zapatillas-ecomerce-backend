package com.sneakersEcomerce.sneakersEcomerceBackend.productWeistStock;

import com.sneakersEcomerce.sneakersEcomerceBackend.weist.WeistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductWeistStockRepository extends JpaRepository<ProductWeistStockModel, Integer> {
    List<ProductWeistStockModel> findByProduct(ProductModel product);
    Optional<ProductWeistStockModel> findByProductAndWeist(ProductModel product, WeistModel weist);
    Optional<ProductWeistStockModel> findByProduct_ProductIdAndWeist_Id(Integer productId, Integer weistId);
}
