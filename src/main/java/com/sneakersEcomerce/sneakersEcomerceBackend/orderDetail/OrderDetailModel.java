package com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @OneToOne(mappedBy = "orderDetail")
    @JsonManagedReference
    private Integer order;

    private Integer amount;

}
