package com.sneakersEcomerce.sneakersEcomerceBackend.adress;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adress")
public class AdressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private Integer adressId;

    private String locality;
    private String country;
    private String province;
    private String city;

    @ManyToMany(mappedBy = "adresses")
    private Set<UserModel>users=new HashSet<>();

    @OneToOne(mappedBy = "adress")
    @JsonBackReference
    private OrderModel order;
}
