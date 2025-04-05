package com.Disponibilite.Disponibilite.disponibilite;


import com.Disponibilite.Disponibilite.Enseignant.EnseignantModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "disponibilite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class disponibiilteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date date_dispo;
    @ManyToMany(mappedBy = "disponibilites")
    private List<EnseignantModel> enseignants=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_dispo() {
        return date_dispo;
    }

    public void setDate_dispo(Date date_dispo) {
        this.date_dispo = date_dispo;
    }

    public List<EnseignantModel> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<EnseignantModel> enseignants) {
        this.enseignants = enseignants;
    }
}
