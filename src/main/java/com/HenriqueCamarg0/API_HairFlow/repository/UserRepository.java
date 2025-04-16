package com.HenriqueCamarg0.API_HairFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.HenriqueCamarg0.API_HairFlow.Entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
