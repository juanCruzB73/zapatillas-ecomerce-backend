package com.sneakersEcomerce.sneakersEcomerceBackend.catalog;

import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
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
@Table(name="catalog")
public class CatalogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY.IDENTITY)
    @Column(name = "catalog_id")
    private Integer catalogId;

    private String catalogName;
    @OneToOne(mappedBy = "catalog")
    private ProductModel product;
}
