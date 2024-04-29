package ru.marinin.ovito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.ovito.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
