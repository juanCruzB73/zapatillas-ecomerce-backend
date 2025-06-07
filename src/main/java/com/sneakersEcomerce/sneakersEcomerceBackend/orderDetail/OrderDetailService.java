package com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderDTO;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderMapper;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderDetailService extends GenericServiceImpl<OrderDetailModel,Integer> {
    @Autowired
    OrderDetailMapper orderDetailMapper;
    public OrderDetailModel save(@RequestBody OrderDetailDTO entity) {
        try {
            var orderDetail=orderDetailMapper.fromCreateToOrderDetail(entity);
            return super.save(orderDetail);
        }catch (Exception e){
            System.out.println(e);
            return new OrderDetailModel();
        }

    }
    public OrderDetailService(OrderDetailRepository orderDetailRepository){
        super(orderDetailRepository);
    }
}
