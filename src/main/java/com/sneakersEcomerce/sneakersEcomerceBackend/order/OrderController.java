package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericService;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductCreateDTO;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends GenericController<OrderModel,Integer> {
    @Autowired
    OrderService orderService;


    @PostMapping("/create")
    public OrderModel createWithDTO(@RequestBody OrderDTO dto) {
        return orderService.save(dto);
    }


    public OrderController(OrderService orderService){
        super(orderService);
    }
}
