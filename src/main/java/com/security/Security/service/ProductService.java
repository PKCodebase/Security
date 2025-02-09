package com.security.Security.service;

import com.security.Security.model.Product;
import com.security.Security.repository.ProductRepository;

import java.util.List;


public interface ProductService {

    String addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    String updateProductById(Long id,Product product);

    String deleteProductById(Long id);

}
