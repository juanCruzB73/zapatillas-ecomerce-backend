package com.sneakersEcomerce.sneakersEcomerceBackend.generycs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<T,ID extends Serializable>implements GenericService<T,ID> {
    protected final JpaRepository<T,ID>repository;

    public GenericServiceImpl(JpaRepository<T,ID>repository){
        this.repository=repository;
    }

    @Override
    public T save(T entity){
        return repository.save(entity);
    }
    @Override
    public Optional<T>findById(ID id){
        return repository.findById(id);
    }
    @Override
    public List<T>findAll(){
        return repository.findAll();
    }
    @Override
    public void deleteById(ID id){
        repository.deleteById(id);
    }
}
