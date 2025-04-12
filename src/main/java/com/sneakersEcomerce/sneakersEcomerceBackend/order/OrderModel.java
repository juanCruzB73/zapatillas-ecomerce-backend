package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sneakersEcomerce.sneakersEcomerceBackend.adress.AdressModel;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @OneToOne(mappedBy = "order")
    @JsonManagedReference
    private Integer orderDetail;

    private Integer total;

    @OneToMany(mappedBy = "oder")
    @JsonManagedReference
    private List<Integer>descuentos=new ArrayList<>();//change type when model

    private String purchaingDate;

    @OneToOne(mappedBy = "order")
    @JsonManagedReference
    private AdressModel adress;


}
