package com.security.Security.controller;

import com.security.Security.model.Product;
import com.security.Security.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productServiceimpl;



    public ProductController(ProductServiceImpl productServiceimpl) {
        this.productServiceimpl = productServiceimpl;

    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@Valid @RequestBody  Product product){
        return ResponseEntity.ok(productServiceimpl.addProduct(product));
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(Product product){
        return productServiceimpl.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productServiceimpl.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable Long id,@Valid @RequestBody Product product){
        return ResponseEntity.ok(productServiceimpl.updateProductById(id,product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        return ResponseEntity.ok(productServiceimpl.deleteProductById(id));
    }


}
