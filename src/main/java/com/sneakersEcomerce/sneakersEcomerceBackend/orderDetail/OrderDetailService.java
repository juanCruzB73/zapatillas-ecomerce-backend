package com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService extends GenericServiceImpl<OrderDetailModel,Integer> {
    public OrderDetailService(OrderDetailRepository orderDetailRepository){
        super(orderDetailRepository);
    }
}
