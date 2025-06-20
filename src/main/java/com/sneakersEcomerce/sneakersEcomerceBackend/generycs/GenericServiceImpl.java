package com.sneakersEcomerce.sneakersEcomerceBackend.generycs;

import com.sneakersEcomerce.sneakersEcomerceBackend.orderDetail.OrderDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<T extends Activable,ID extends Serializable>implements GenericService<T,ID> {
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
        Optional<T> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            T entity = optionalEntity.get();
            entity.setActive(false);
            repository.save(entity);
        } else {
            throw new EntityNotFoundException("Entity with ID " + id + " not found.");
        }
    }
    @Override
    public T update(ID id, T entity) {
        if (repository.existsById(id)) {
            return repository.save(entity); // assumes entity has same ID
        } else {
            throw new RuntimeException("Entity with ID " + id + " not found");
        }
    }

}
