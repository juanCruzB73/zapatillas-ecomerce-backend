package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;

public class OrderService extends GenericServiceImpl<OrderModel,Integer> {
    public OrderService(OrderRepository orderRepository){
        super(orderRepository);
    }
}
