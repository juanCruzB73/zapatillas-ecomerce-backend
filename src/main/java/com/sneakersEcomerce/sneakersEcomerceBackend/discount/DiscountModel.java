package com.sneakersEcomerce.sneakersEcomerceBackend.discount;

import com.sneakersEcomerce.sneakersEcomerceBackend.prices.PriceModel;
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
@Table(name = "discount")
public class DiscountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY.IDENTITY)
    @Column(name = "price_id")
    private Integer priceId;

    private String startDate;
    private String endDate;

    //make relation
    private PriceModel priceModel;
}
