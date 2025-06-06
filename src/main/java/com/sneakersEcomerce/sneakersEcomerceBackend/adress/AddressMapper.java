package com.sneakersEcomerce.sneakersEcomerceBackend.adress;

import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserModel;
import com.sneakersEcomerce.sneakersEcomerceBackend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AdressRepository adressRepository;

    public AdressModel fromCreateToAddress(AddressDTO addressDTO){
        AdressModel address = addressDTO.addresId()
                .map(id->adressRepository.findById(id).orElseThrow(()->new RuntimeException("address not found")))
                .orElse(new AdressModel());

        address.setCity(addressDTO.city());
        address.setProvince(addressDTO.province());
        address.setActive(true);
        address.setStreet(addressDTO.street());
        address.setStreetNumber(addressDTO.streetNumber());

        UserModel user=userRepository.findById(addressDTO.userId()).orElseThrow(()->new RuntimeException("address not found"));

        if(user!=null){
            address.setUser(user);
        }

        return address;
    }
}
