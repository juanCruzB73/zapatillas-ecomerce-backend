package com.sneakersEcomerce.sneakersEcomerceBackend.generycs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public abstract class GenericController<T,ID extends Serializable> {

    protected final GenericService<T, ID> service;

    public GenericController(GenericService<T,ID>service){
        this.service=service;
    }
    @GetMapping
    public List<T>getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<T>getById(@PathVariable ID id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("")
    public T create(@RequestBody T entity){
        System.out.println(entity);
        return service.save(entity);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id){
        service.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        try {
            T updated = service.update(id, entity);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
