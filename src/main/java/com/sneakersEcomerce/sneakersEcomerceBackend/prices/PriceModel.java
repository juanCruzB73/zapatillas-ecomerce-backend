package com.sneakersEcomerce.sneakersEcomerceBackend.prices;

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
@Table(name = "price")
public class PriceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY.IDENTITY)
    @Column(name = "price_id")
    private Integer priceId;

    private Integer purchasePrice;
    private Integer salePrice;

    @OneToOne(mappedBy = "price")
    private ProductDetailModel productDetailModel;

    //añadir relacion
    private String discount;//change type when model
}
