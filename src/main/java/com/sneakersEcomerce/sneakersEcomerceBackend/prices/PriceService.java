package com.sneakersEcomerce.sneakersEcomerceBackend.prices;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PriceService extends GenericServiceImpl<PriceModel,Integer> {
    public PriceService(PriceRepository priceRepository){
        super(priceRepository);
    }
}
