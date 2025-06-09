package com.sneakersEcomerce.sneakersEcomerceBackend.img;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.Activable;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "imgs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgModel implements Activable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id")
    private Integer imgId;

    private  String imgName;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductModel product;

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
