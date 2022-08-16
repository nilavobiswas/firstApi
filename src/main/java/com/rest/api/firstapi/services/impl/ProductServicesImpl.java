package com.rest.api.firstapi.services.impl;

import com.rest.api.firstapi.entities.Product;
import com.rest.api.firstapi.repositories.ProductRepository;
import com.rest.api.firstapi.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    private ProductRepository productRepository;

    @Autowired
    public ProductServicesImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(Product product, int productId) {
        Product data1 = this
                .productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Data not found"));
        data1.setName(product.getName());
        data1.setCity(product.getCity());
        data1.setAge(product.getAge());
        data1.setId(product.getId());
        return this.productRepository.save(data1);
    }

    @Override
    public void del(int productId) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Not Deleted"));
        this.productRepository.delete(product);
    }

    @Override
    public Product getById(int productId) {
        return this.productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("No data found"));
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
