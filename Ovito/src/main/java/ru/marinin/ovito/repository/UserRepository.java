package ru.marinin.ovito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.ovito.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
