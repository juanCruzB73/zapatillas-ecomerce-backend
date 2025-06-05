package com.sneakersEcomerce.sneakersEcomerceBackend.weist;

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
@Table(name = "weist")
public class WeistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weist_id")
    private Integer weistId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    private String weistName;
    private Boolean status;
}
