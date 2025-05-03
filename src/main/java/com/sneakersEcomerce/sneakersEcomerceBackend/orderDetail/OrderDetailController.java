package com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordertetails")
public class OrderDetailController extends GenericController<OrderDetailModel,Integer> {
    public OrderDetailController(OrderDetailService orderDetailService){
        super(orderDetailService);
    }
}
