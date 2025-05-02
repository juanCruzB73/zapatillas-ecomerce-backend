package com.sneakersEcomerce.sneakersEcomerceBackend.discount;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController extends GenericController<DiscountModel,Integer> {
    public DiscountController(DiscountService discountService){
        super(discountService);
    }
}
