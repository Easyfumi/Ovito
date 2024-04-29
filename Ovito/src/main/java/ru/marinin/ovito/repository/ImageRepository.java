package ru.marinin.ovito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.ovito.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
