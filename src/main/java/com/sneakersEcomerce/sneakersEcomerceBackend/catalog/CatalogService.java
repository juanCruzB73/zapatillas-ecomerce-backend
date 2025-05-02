package com.sneakersEcomerce.sneakersEcomerceBackend.catalog;

import com.sneakersEcomerce.sneakersEcomerceBackend.adress.AdressRepository;
import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CatalogService extends GenericServiceImpl<CatalogModel,Integer> {
    public CatalogService(CatalogRepository catalogRepository){
        super(catalogRepository);
    }
}
