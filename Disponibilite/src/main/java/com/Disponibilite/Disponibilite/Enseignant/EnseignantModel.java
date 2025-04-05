package com.Disponibilite.Disponibilite.Enseignant;

import com.Disponibilite.Disponibilite.disponibilite.disponibiilteModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "enseignants")
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 100)
    private String name;


    @Column(unique = true, length = 100)
    private String email;


    @Column(length = 20)
    private String tel;


    @Column(nullable = false, length = 50)
    private String grade;


    @Column(nullable = false, length = 100)
    private String specialite;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "enseignant_disponibilites",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "disponibilite_id")
    )
    @JsonIgnore
    private List<disponibiilteModel> disponibilites = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getGrade() {
        return grade;
    }

    public List<disponibiilteModel> getDisponibilites() {
        return disponibilites;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setDisponibilites(List<disponibiilteModel> disponibilites) {
        this.disponibilites = disponibilites;
    }
}