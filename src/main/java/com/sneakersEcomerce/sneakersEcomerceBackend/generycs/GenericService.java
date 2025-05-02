package com.sneakersEcomerce.sneakersEcomerceBackend.generycs;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public interface GenericService<T, ID extends Serializable> {
    T save(T entity);
    Optional<T>findById(ID id);
    List<T>findAll();
    void deleteById(ID id);
    T update(ID id, T entity);

}
