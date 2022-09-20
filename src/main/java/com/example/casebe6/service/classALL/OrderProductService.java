package com.example.casebe6.service.classALL;

import com.example.casebe6.models.OderProduct;
import com.example.casebe6.repository.IOderProductRepo;
import com.example.casebe6.service.interfaceALL.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService implements IOrderProductService {
    @Autowired
    IOderProductRepo iOderProductRepo;

    @Override
    public List<OderProduct> findAllProductByIdUser(int id) {
        return (List<OderProduct>) iOderProductRepo.findAllProductByIdUser(id);
    }

    public OderProduct save(OderProduct oderProduct) {
        return iOderProductRepo.save(oderProduct);
    }

    public List<OderProduct> findAll() {
        return (List<OderProduct>) iOderProductRepo.findAll();
    }
}

