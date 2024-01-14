package com.example.server.service;

import com.example.server.entity.BaseEntity;
import com.example.server.repositories.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class AbstractService<T extends BaseEntity> {

    protected final Repository<T> repository;

    public AbstractService(Repository<T> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        return repository.save(entity);
    }
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }
    public List<T> findAll() {
        return repository.findAll();
    }

    public void delete(T entity){
        repository.delete(entity);
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
