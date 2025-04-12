package com.sneakersEcomerce.sneakersEcomerceBackend.productDetail;

import com.sneakersEcomerce.sneakersEcomerceBackend.prices.PriceModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.weist.WeistModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_detail")
public class ProductDetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY.IDENTITY)
    @Column(name = "product_detail_id")
    private Integer productDetailId;

    @OneToMany(mappedBy = "productDetailModel")
    private List<WeistModel> weist;
    private Integer stock;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    private ProductModel product;
    private String color;
    private boolean state;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id", referencedColumnName = "price_id")
    private PriceModel price;

}
