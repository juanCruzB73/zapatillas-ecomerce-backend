package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductCreateDTO;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderService extends GenericServiceImpl<OrderModel,Integer> {
    @Autowired
    OrderMapper orderMapper;

    public OrderModel save(@RequestBody OrderDTO entity) {
        try {
            var order=orderMapper.fromCreateToOrder(entity);
            return super.save(order);
        }catch (Exception e){
            System.out.println(e);
            return new OrderModel();
        }

    }
    public OrderService(OrderRepository orderRepository){
        super(orderRepository);
    }
}
