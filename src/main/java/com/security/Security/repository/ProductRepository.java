package com.security.Security.repository;


import com.security.Security.model.Product;
import com.security.Security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    User findByUsername(String username);
}
