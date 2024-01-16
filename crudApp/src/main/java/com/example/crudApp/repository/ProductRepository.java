package com.example.crudApp.repository;

import com.example.crudApp.model.Category;
import com.example.crudApp.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAll(Pageable page);
    List<Product> findAllByIsDeletedIsFalse(Pageable page);
    List<Product> findAllByCategory(Category category, Pageable page);
    Product save(Product entity);
    Optional<Product> findById(Integer id);
}