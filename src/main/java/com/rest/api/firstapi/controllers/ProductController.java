package com.rest.api.firstapi.controllers;

import com.rest.api.firstapi.entities.Product;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/")
    public Product test(){

        Product product = new Product();
        product.setName("Nilavo");
        product.setCity("Kolkata");
        product.setAge(30);

        return product;
    }
}
