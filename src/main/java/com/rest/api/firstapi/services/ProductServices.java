package com.rest.api.firstapi.services;

import com.rest.api.firstapi.entities.Product;

import java.util.List;

public interface ProductServices {
    Product create(Product product);
    Product update(Product product, int productId);
    void del(int productId);
    Product getById(int productId);
    List<Product> getAll();

}
