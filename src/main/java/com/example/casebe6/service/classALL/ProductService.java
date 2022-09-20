package com.example.casebe6.service.classALL;
import com.example.casebe6.models.Product;
import com.example.casebe6.repository.IProductRepo;
import com.example.casebe6.service.interfaceALL.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo iProductRepo;

    public Page<Product> findAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }

    public Product save(Product product){
        return iProductRepo.save(product);
    }

    public void delete(Long id) {
        iProductRepo.deleteById(id);
    }

    public Optional<Product> findById(Long id){
        return iProductRepo.findById(id);
    }

}
