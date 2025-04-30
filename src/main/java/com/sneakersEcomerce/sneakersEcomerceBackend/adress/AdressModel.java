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
//@NoArgsConstructor
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
    //@JsonBackReference("user-address")
    private Set<UserModel> users = new HashSet<>();

    @OneToOne(mappedBy = "adress")
    //@JsonBackReference("order-address")
    private OrderModel order;


    public AdressModel() {
    }

    public AdressModel(Integer adressId, String locality, String country, String province, Set<UserModel> users, String city, OrderModel order) {
        this.adressId = adressId;
        this.locality = locality;
        this.country = country;
        this.province = province;
        this.users = users;
        this.city = city;
        this.order = order;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setUsers(Set<UserModel> users) {
        this.users = users;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public String getLocality() {
        return locality;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public Set<UserModel> getUsers() {
        return users;
    }

    public OrderModel getOrder() {
        return order;
    }
}
