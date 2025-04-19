package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.sneakersEcomerce.sneakersEcomerceBackend.catalog.CatalogModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.productDetail.ProductDetailModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    private String productName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalog_id",referencedColumnName = "catalog_id")
    private CatalogModel catalog;
    private String productType;//enum?
    @OneToOne(mappedBy = "product")
    private ProductDetailModel productDetail;
}
