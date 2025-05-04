package com.sneakersEcomerce.sneakersEcomerceBackend.weist;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weist")
public class WeistController extends GenericController<WeistModel,Integer> {
    public WeistController(WeistService weistService){
        super(weistService);
    }
}
