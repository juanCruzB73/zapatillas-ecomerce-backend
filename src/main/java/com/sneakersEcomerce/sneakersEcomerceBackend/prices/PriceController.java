package com.sneakersEcomerce.sneakersEcomerceBackend.prices;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController extends GenericController<PriceModel,Integer> {
    public PriceController(PriceService priceService){
        super(priceService);
    }
}
