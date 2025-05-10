package com.Disponibilite.Disponibilite.Enseignant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepo extends JpaRepository<EnseignantModel, Long> {
    boolean existsByEmail(String email);
}