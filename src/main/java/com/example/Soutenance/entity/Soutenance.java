package com.example.Soutenance.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "soutenances")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Soutenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEtudiant;
    private String email;
    private String titrePfe;
    private String encadrant;

    // Champs à remplir après planification
    private String presidentJury;
    private String rapporteur;
    private String salle;
    private LocalTime heure;
    private LocalDate date;
}
