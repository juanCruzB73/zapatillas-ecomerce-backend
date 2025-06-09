package com.sneakersEcomerce.sneakersEcomerceBackend.discount;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.Activable;
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
@Table(name = "discount")
public class DiscountModel implements Activable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Integer discountId;

    private Integer number;

    private Boolean active;


    @Override
    public void setActive(boolean active) {
        this.active=active;
    }

    @Override
    public boolean active() {
        return false;
    }
}
