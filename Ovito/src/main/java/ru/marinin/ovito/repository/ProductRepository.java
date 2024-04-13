package ru.marinin.ovito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.marinin.ovito.models.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = "SELECT a.* FROM Product a where a.title = ?1")
    Optional<Product> findByTitle(String title);
}
