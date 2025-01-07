package org.team6.coffeebeanery.product.repository;

import org.team6.coffeebeanery.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
