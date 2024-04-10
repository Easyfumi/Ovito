package ru.marinin.ovito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.ovito.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
