package com.example.casebe6.models.repository;

import com.example.casebe6.models.OderProduct;
import com.example.casebe6.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOderProductRepo extends CrudRepository<OderProduct, Integer> {
    @Query(nativeQuery = true, value = "select  * from oder_product where user_id=:id")
    List<OderProduct> findAllProductByIdUser(@Param("id") int id);
}
