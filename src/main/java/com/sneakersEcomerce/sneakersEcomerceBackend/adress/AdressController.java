package com.sneakersEcomerce.sneakersEcomerceBackend.adress;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adress")
public class AdressController extends GenericController<AdressModel,Integer> {

    @Autowired
    AdressService adressService;

    @PostMapping("/create")
    public AdressModel createWithDTO(@RequestBody AddressDTO dto) {
        return adressService.save(dto);
    }

    public AdressController(AdressService adressService){
        super(adressService);
    }

}
