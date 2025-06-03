package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sneakersEcomerce.sneakersEcomerceBackend.catalog.CatalogModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.prices.PriceModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.productDetail.ProductDetailModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.weist.WeistModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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
    @JsonManagedReference
    private CatalogModel catalog;

    private String productType;

    @OneToMany(mappedBy = "product")
    private Set<WeistModel> weist;

    private Integer stock;

    private String color;

    private Boolean state;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ImgModel> imgs;

    private String sex;//enum?

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "price_id")
    @JsonManagedReference
    private PriceModel price;
}
