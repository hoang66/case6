package com.example.casebe6.repository;

import com.example.casebe6.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepo extends CrudRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM seller where name like concat('%',:name,'%');")
    Iterable<Product> findAllByNameContaining(String name);
}
