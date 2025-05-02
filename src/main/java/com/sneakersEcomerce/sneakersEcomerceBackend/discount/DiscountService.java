package com.sneakersEcomerce.sneakersEcomerceBackend.discount;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DiscountService extends GenericServiceImpl<DiscountModel,Integer> {
    public DiscountService(DiscountRepository discountRepository){
        super(discountRepository);
    }
}
