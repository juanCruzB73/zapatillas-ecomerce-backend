package com.sneakersEcomerce.sneakersEcomerceBackend.catalog;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/catalog")
    public class CatalogController extends GenericController<CatalogModel,Integer> {
    public CatalogController(CatalogService catalogService){
        super(catalogService);
    }
}
