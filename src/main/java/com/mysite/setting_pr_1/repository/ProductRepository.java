package com.mysite.setting_pr_1.repository;

import com.mysite.setting_pr_1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
