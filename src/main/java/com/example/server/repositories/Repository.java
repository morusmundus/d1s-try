package com.example.server.repositories;

import com.example.server.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends BaseEntity> extends JpaRepository<T, Long> {
    Optional<T> findById(Long id);
    List<T> findAll();
    void delete(T entity);
    void deleteById(Long id);
}
