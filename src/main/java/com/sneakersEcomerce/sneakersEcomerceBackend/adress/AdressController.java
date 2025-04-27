package com.sneakersEcomerce.sneakersEcomerceBackend.adress;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adress")
public class AdressController extends GenericController<AdressModel,Integer> {

    public AdressController(AdressService adressService){
        super(adressService);
    }
    @PostMapping
    public AdressModel create(@RequestBody AdressModel adressModel) {
        return service.save(adressModel);
    }
}
