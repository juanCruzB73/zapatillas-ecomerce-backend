package com.sneakersEcomerce.sneakersEcomerceBackend.adress;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adress")
public class AdressController extends GenericController<AdressModel,Integer> {

    @Autowired
    AdressService adressService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AdressModel>> getAddressesByUserId(@PathVariable Long userId) {
        List<AdressModel> addresses = adressService.getAddressesByUserId(userId);
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("/create")
    public AdressModel createWithDTO(@RequestBody AddressDTO dto) {
        return adressService.save(dto);
    }

    public AdressController(AdressService adressService){
        super(adressService);
    }

}
