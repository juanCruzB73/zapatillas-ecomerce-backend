package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sneakersEcomerce.sneakersEcomerceBackend.adress.AdressModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.discount.DiscountModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail.OrderDetailModel;
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
@Table(name="order")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    @JsonManagedReference
    private OrderDetailModel orderDetail;

    private Integer total;

    @OneToMany
    @JsonManagedReference
    private List<DiscountModel>descuentos=new ArrayList<>();//change type when model

    private String purchaingDate;

    @OneToOne
    @JoinColumn(name = "adress_id")
    @JsonManagedReference
    private AdressModel adress;


}
