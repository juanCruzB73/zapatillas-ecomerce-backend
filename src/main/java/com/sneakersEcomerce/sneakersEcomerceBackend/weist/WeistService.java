package com.sneakersEcomerce.sneakersEcomerceBackend.weist;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WeistService extends GenericServiceImpl<WeistModel,Integer> {
    public WeistService(WeistRepository weistRepository){
        super(weistRepository);
    }
}
