package com.sneakersEcomerce.sneakersEcomerceBackend.img;

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
public class ImgModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id")
    private Integer imgId;

    private  String imgName;
    private String imgUrl;

}
