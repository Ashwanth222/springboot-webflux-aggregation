package com.springboot.springbootproductservice.service;

import com.springboot.springbootproductservice.model.Product;
import com.springboot.springbootproductservice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public String addAddress(Product product) {
        productRepo.save(product);
        return "Product Added Successfully";
    }

    public Product findProductById(int id) {
        Optional<Product> product = productRepo.findById(id);
        return product.get();
    }

}

