package com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail;

import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailMapper {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ProductRepository productRepository;

    public OrderDetailModel fromCreateToOrderDetail(OrderDetailDTO orderDetailDTO){
        OrderDetailModel orderDeatil = orderDetailDTO.orderDetailId()
                .map(id->orderDetailRepository.findById(id).orElseThrow(()->new RuntimeException("order detail not found")))
                .orElse(new OrderDetailModel());

        orderDeatil.setAmount(orderDetailDTO.amount());
        orderDeatil.setActive(true);

        ProductModel product=productRepository.findById(orderDetailDTO.product()).orElseThrow(()->new RuntimeException("Product not found"));

        if(product!=null){
            orderDeatil.setProduct(product);
        }

        return orderDeatil;
    }

}
