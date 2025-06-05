package com.sneakersEcomerce.sneakersEcomerceBackend.adress;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private String province;//make model
    private String city;//make model
    private String street;
    private String streetNumber;
    private Boolean active;

    @ManyToMany(mappedBy = "adresses")
    //@JsonBackReference("user-address")
    private Set<UserModel> users = new HashSet<>();

    @OneToOne(mappedBy = "address")
    //@JsonBackReference("order-address")
    private OrderModel order;




}
