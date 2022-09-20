package com.example.casebe6.repository;

import com.example.casebe6.models.OderProduct;
import com.example.casebe6.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IProductRepo extends PagingAndSortingRepository<Product, Long> {
    @Query(nativeQuery = true, value = "select  * from product where catagorie_id=:id")
    List<Product> findAllProductCatagorieByIdname(@Param("id") long id);
    @Query(nativeQuery = true, value = "select * from product where name_st LIKE %:nameSt%  ")
    List<Product> findPostUser(@Param("nameSt") String nameSt );
    @Query(nativeQuery = true, value = "select * from product ")
    List<Product> getAll(Pageable pageable);

}
