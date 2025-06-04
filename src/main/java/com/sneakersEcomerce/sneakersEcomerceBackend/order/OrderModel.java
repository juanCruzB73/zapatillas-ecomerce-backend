package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sneakersEcomerce.sneakersEcomerceBackend.adress.AdressModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.discount.DiscountModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail.OrderDetailModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;
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
@Table(name="orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    private String date;
    private Integer total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailModel> orderDetails = new ArrayList<>();

    private String status;

    private String purchaingDate;

}
