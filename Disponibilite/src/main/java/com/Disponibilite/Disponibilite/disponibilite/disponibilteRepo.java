package com.Disponibilite.Disponibilite.disponibilite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface disponibilteRepo extends JpaRepository<disponibiilteModel,Long> {
}
