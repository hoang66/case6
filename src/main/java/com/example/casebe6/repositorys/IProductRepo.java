package com.example.casebe6.repositorys;

import com.example.casebe6.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepo extends CrudRepository<Product,Long> {
}
