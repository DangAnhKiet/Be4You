package com.example.beforyou.repository;

import com.example.beforyou.model.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByCode(String code);

    List<Product> findAllBy(Pageable pageable);
}
