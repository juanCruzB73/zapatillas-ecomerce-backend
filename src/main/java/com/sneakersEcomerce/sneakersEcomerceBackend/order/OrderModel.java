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


    @ManyToOne
    @JoinColumn(name = "address_id")
    private AdressModel address;

    private Boolean active;

    @OneToMany(mappedBy = "order") // o "orderDetail" si decides
    private List<OrderDetailModel> orderDetails;
    @ManyToOne
    @JoinColumn(name = "user_id") // o el nombre que uses para la FK
    private UserModel user;
}
