package com.example.casebe6.repository;

import com.example.casebe6.models.Catagorie;
import com.example.casebe6.models.OderProduct;
import com.example.casebe6.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICatagorieRepo extends CrudRepository<Catagorie, Long> {

}
