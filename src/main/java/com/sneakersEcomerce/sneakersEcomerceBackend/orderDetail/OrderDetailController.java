package com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderDTO;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordertetails")
public class OrderDetailController extends GenericController<OrderDetailModel,Integer> {

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/create")
    public OrderDetailModel createWithDTO(@RequestBody OrderDetailDTO dto) {
        return orderDetailService.save(dto);
    }


    public OrderDetailController(OrderDetailService orderDetailService){
        super(orderDetailService);
    }
}
