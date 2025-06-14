package com.sneakersEcomerce.sneakersEcomerceBackend.mercadoPago;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderDTO;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.order.OrderService;
import com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail.OrderDetailModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mercado")
public class MercadoPagoController {

    @Autowired
    OrderService orderService;

    Dotenv dotenv = Dotenv.load();

    @PostMapping
    public ResponseEntity<String> mercado(@RequestBody OrderDTO body)throws Exception{

        MercadoPagoConfig.setAccessToken(dotenv.get("MERCADO_PAGO_ACCESS_TOKEN"));
        List<PreferenceItemRequest> items = new ArrayList<>();

        //order
        OrderModel order=orderService.save(body);

        for(OrderDetailModel oderDetail:order.getOrderDetails()){
            ProductModel product=oderDetail.getProduct();
            Double price= Double.valueOf(product.getPrice().getSalePrice());
            PreferenceItemRequest  item= PreferenceItemRequest.builder()
                    .id(product.getProductId().toString())
                    .title(product.getProductName())
                    .description(product.getDescription())
                    .quantity(oderDetail.getAmount())
                    .currencyId("ARS")
                    .unitPrice(BigDecimal.valueOf(price))
                    .build();
            items.add(item);
        }

        PreferenceBackUrlsRequest backUrls =
                PreferenceBackUrlsRequest.builder()
                        .success("https://localhost:5173/paymentSuccess")
                        .pending("https://localhost:5173/")
                        .failure("https://localhost:5173/paymentFailure")
                        .build();

        List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
        excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("ticket").build());

        PreferencePaymentMethodsRequest paymentMethods = PreferencePaymentMethodsRequest.builder()
                .excludedPaymentTypes(excludedPaymentTypes)
                .installments(1)
                .build();


        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .paymentMethods(paymentMethods)
                .autoReturn("approved")
                .build();

        PreferenceClient client = new PreferenceClient();
        Preference preference = client.create(preferenceRequest);

        String prefId = preference.getId();

        System.out.println("URL de pago: " + preference.getSandboxInitPoint());

        return ResponseEntity.status(HttpStatus.OK).body(
                "{\"preferenceId\":\""+prefId+ "\", \"initPoint\": \"" + preference.getSandboxInitPoint()+"\"}"
        );
    }
}
