package com.security.Security.controller;

import com.security.Security.model.Product;
import com.security.Security.service.impl.ProductServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }


    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productServiceImpl.addProduct(product));
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productServiceImpl.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable Long id, @Valid @RequestBody Product product) {
        return ResponseEntity.ok(productServiceImpl.updateProductById(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productServiceImpl.deleteProductById(id));
    }
}
