package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends GenericController<OrderModel,Integer> {
    public OrderController(GenericService genericService){
        super(genericService);
    }
}
