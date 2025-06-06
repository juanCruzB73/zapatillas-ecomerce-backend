package com.sneakersEcomerce.sneakersEcomerceBackend.adress;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericService;
import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductCreateDTO;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdressService extends GenericServiceImpl<AdressModel,Integer> {
    @Autowired
    AddressMapper addressMapper;
    public AdressModel save(@RequestBody AddressDTO entity) {
        try {
            var address=addressMapper.fromCreateToAddress(entity);
            return super.save(address);
        }catch (Exception e){
            System.out.println(e);
            return new AdressModel();
        }

    }
    public AdressService(AdressRepository adress){
        super(adress);
    }
}
