package com.example.casebe6.service.interfaceALL;

import com.example.casebe6.models.OderProduct;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IOrderProductService {
    List<OderProduct> findAllProductByIdUser(int id);
}
