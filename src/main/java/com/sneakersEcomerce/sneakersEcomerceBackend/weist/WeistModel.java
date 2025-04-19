package com.sneakersEcomerce.sneakersEcomerceBackend.weist;

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
@Table(name = "weist")
public class WeistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weist_id")
    private Integer weistId;
    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetailModel productDetailModel;
    private String weistName;
}
