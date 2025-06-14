package com.sneakersEcomerce.sneakersEcomerceBackend.order;

import com.sneakersEcomerce.sneakersEcomerceBackend.adress.AdressModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.adress.AdressRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.img.ImgModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail.OrderDetailModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail.OrderDetailRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderMapper {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AdressRepository adressRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    UserRepository userRepository;

    public OrderModel fromCreateToOrder(OrderDTO orderDTO){
        OrderModel order = orderDTO.orderId()
                .map(id->orderRepository.findById(id).orElseThrow(()->new RuntimeException("order not found")))
                .orElse(new OrderModel());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = LocalDate.now().format(formatter);
        order.setDate(formattedDate);

        order.setActive(true);


        AdressModel address = adressRepository.findById(orderDTO.address()).orElseThrow(()->new RuntimeException("address not found"));
        if(address!=null){
            order.setAddress(address);
        }

        List<OrderDetailModel> orderDetails=new ArrayList<>();
        if(orderDTO.orderDetails().size()>0 && orderDTO.orderDetails()!=null){
            for (Integer orderDetailId:orderDTO.orderDetails()){
                OrderDetailModel orderDetail=orderDetailRepository.findById(orderDetailId).orElseThrow(()->new RuntimeException("orderDetail not found"));
                if(orderDetail!=null){
                    orderDetails.add(orderDetail);
                }
            }
        }
        order.setOrderDetails(orderDetails);

        Integer total=0;
        if(order.getOrderDetails().size()>0){
            for(OrderDetailModel orderDetailModel:order.getOrderDetails()){
                total+=orderDetailModel.getAmount()*orderDetailModel.getProduct().getPrice().getSalePrice();
            }
        }
        order.setTotal(total);

        UserModel user=userRepository.findById(orderDTO.user()).orElseThrow(()->new RuntimeException("address not found"));
        order.setUser(user);

        return order;
    }
}
