package com.sneakersEcomerce.sneakersEcomerceBackend.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sneakersEcomerce.sneakersEcomerceBackend.discount.DiscountModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgModel;

import com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail.OrderDetailModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.prices.PriceModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
@ToString(exclude = "weists")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    private String productName;

    private String productType;

    private String description;

    private Set<String> weists = new HashSet<>();

    private Integer stock;

    private String color;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)

    private Set<ImgModel> imgs;

    private String sex;

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "price_id")

    private PriceModel price;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private DiscountModel discount;

    private Boolean active;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetailModel> orderDetail;

}
