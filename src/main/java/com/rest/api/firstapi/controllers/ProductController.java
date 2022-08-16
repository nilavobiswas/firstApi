package com.rest.api.firstapi.controllers;

import com.rest.api.firstapi.entities.Product;
import com.rest.api.firstapi.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    //Create
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product product1 = this.productServices.create(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    //Update
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int productId){
        Product product1 = this.productServices.update(product,productId);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

    //Del
    @DeleteMapping("/{productId}")
    public ResponseEntity<Map<String,String>> updateProduct(@PathVariable int productId){
        this.productServices.del(productId);
        Map<String,String> message = Map.of("message","Product Deleted Successfully");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId){
        Product product = this.productServices.getById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //GetAll
    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> all = this.productServices.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
