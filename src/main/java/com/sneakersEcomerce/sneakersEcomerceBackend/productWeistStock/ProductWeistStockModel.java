package com.sneakersEcomerce.sneakersEcomerceBackend.productWeistStock;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.Activable;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.weist.WeistModel;
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
@Table(name = "porduct_wesit_stock")
public class ProductWeistStockModel implements Activable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer stock;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private ProductModel product;

    @ManyToOne
    @JoinColumn(name = "weist_id")
    private WeistModel weist;

    @Override
    public void setActive(boolean active) {
        this.active=active;
    }

    @Override
    public boolean active() {
        return Boolean.TRUE.equals(this.active);
    }
}
