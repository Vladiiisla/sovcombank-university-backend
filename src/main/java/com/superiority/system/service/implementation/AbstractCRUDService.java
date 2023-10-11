package com.superiority.system.service.implementation;

import com.superiority.system.service.interf.CRUDService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCRUDService <E,K> implements CRUDService<E,K> {
    abstract JpaRepository<E,K> getRepository();
    @Override
    public void create(E entity) {
        getRepository().save(entity);
    }

    @Override
    public E findById(K id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public List<E> findAll() {
        List<E> objects = new ArrayList<>();
        getRepository().findAll().forEach(objects::add);
        return objects;
    }

    @Override
    public E update(E entity) {
        getRepository().save(entity);
        return entity;
    }

    @Override
    public void delete(E entity) {
        getRepository().delete(entity);
    }
}
