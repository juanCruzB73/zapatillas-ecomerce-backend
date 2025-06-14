package com.sneakersEcomerce.sneakersEcomerceBackend.weist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sneakersEcomerce.sneakersEcomerceBackend.productWeistStock.ProductWeistStockModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weist")
public class WeistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String value;

    @OneToMany(mappedBy = "weist", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ProductWeistStockModel> productStocks;
}
