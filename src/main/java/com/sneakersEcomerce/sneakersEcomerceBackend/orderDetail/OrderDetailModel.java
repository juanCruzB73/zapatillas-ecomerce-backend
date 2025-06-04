package com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sneakersEcomerce.sneakersEcomerceBackend.adress.AdressModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;
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
@Table(name = "order_detail")
public class OrderDetailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @OneToOne(mappedBy = "orderDetail")
    private OrderModel order;

    private Integer amount;

    private Boolean status;

    @OneToOne
    @JoinColumn(name = "adress_id")
    //@JsonManagedReference("order-address")
    private AdressModel adress;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

}
