package com.Disponibilite.Disponibilite.Enseignant;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // Génère automatiquement getters, setters, toString, etc.
public class EnseignantDto {
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 2, max = 100)
    private String name;

    @Email(message = "L'email doit être valide")
    private String email; // Assurez-vous que le nom correspond exactement

    @Pattern(regexp = "^[0-9]{8,20}$")
    private String tel;

    @NotBlank
    private String grade;

    @NotBlank
    private String specialite;

    // Lombok @Data génèrera automatiquement :
    // public String getEmail() { return this.email; }
    // public void setEmail(String email) { this.email = email; }
    // ... et ainsi de suite pour les autres propriétés

    public @Email(message = "L'email doit être valide") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "L'email doit être valide") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Le nom est obligatoire") @Size(min = 2, max = 100) String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Le nom est obligatoire") @Size(min = 2, max = 100) String name) {
        this.name = name;
    }

    public @Pattern(regexp = "^[0-9]{8,20}$") String getTel() {
        return tel;
    }

    public void setTel(@Pattern(regexp = "^[0-9]{8,20}$") String tel) {
        this.tel = tel;
    }

    public @NotBlank String getGrade() {
        return grade;
    }

    public void setGrade(@NotBlank String grade) {
        this.grade = grade;
    }

    public @NotBlank String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(@NotBlank String specialite) {
        this.specialite = specialite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}