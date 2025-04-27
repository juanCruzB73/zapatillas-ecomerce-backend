package com.sneakersEcomerce.sneakersEcomerceBackend.adress;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericService;
import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdressService extends GenericServiceImpl<AdressModel,Integer> {
    public AdressService(AdressRepository adress){
        super(adress);
    }
}
