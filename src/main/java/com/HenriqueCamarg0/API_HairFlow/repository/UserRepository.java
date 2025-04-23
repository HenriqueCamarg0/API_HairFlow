package com.HenriqueCamarg0.API_HairFlow.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HenriqueCamarg0.API_HairFlow.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Método atualizado
    Optional<User> findByEmail(String email);       // Método atualizado
}   