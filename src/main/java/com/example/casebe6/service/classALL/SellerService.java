package com.example.casebe6.service.classALL;

import com.example.casebe6.models.Seller;
import com.example.casebe6.repository.ISellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    ISellerRepo iSellerRepo;

    public Seller save(Seller seller) {
        return iSellerRepo.save(seller);
    }
}
