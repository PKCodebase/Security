package com.security.Security.service.impl;

import com.security.Security.exception.ProductNotFoundException;
import com.security.Security.model.Product;
import com.security.Security.repository.ProductRepository;
import com.security.Security.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product added successfully";
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }

    @Override
    public String updateProductById(Long id,Product product) {
        return productRepository.findById(id)
                .map(product1 -> {
                    product1.setName(product.getName());
                    product1.setPrice(product.getPrice());
                    productRepository.save(product1);
                    return "Product updated successfully";

                }).orElseThrow(()->new ProductNotFoundException("Product not found"));
    }

    @Override
    public String deleteProductById(Long id) {
        return productRepository.findById(id)
                .map(product ->{
                        productRepository.delete(product);
                        return "Product deleted successfully";
                }).orElseThrow(()->new ProductNotFoundException("Product not found"));
    }
}
