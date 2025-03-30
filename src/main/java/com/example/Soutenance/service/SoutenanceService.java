package com.example.Soutenance.service;
import com.example.Soutenance.entity.Soutenance;
import com.example.Soutenance.repository.SoutenanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SoutenanceService {
    private final SoutenanceRepository soutenanceRepository;

    public SoutenanceService(SoutenanceRepository soutenanceRepository) {
        this.soutenanceRepository = soutenanceRepository;
    }

    // 📌 Importation depuis un fichier CSV
    public void importFromCSV(MultipartFile file) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            List<String[]> rows = reader.readAll();

            // Ignorer la première ligne (en-têtes)
            List<Soutenance> soutenances = rows.stream().skip(1).map(data -> {
                Soutenance s = new Soutenance();
                s.setNomEtudiant(data[0]);
                s.setEmail(data[1]);
                s.setTitrePfe(data[2]);
                s.setEncadrant(data[3]);
                return s;
            }).collect(Collectors.toList());

            soutenanceRepository.saveAll(soutenances);
        }
    }
//find by id

    public Optional<Soutenance> getSoutenance(Long id)
    {
        return soutenanceRepository.findById(id);
    }
    //delete by id
    public void deleteSoutenance(Long id)
    {
         soutenanceRepository.deleteById(id);
    }
    //ajout via formulaire
    public Soutenance addSoutenance(Soutenance soutenance) {
        // Set only the fields you want to save
        Soutenance newSoutenance = new Soutenance();
        newSoutenance.setNomEtudiant(soutenance.getNomEtudiant());
        newSoutenance.setEmail(soutenance.getEmail());
        newSoutenance.setTitrePfe(soutenance.getTitrePfe());
        newSoutenance.setEncadrant(soutenance.getEncadrant());

        // Save the entity (id will be auto-generated)
        return soutenanceRepository.save(newSoutenance);
    }

    //  Mise à jour après planification
    public Soutenance updateSoutenance(Long id, Soutenance updatedData) {
        return soutenanceRepository.findById(id).map(soutenance -> {
            soutenance.setPresidentJury(updatedData.getPresidentJury());
            soutenance.setRapporteur(updatedData.getRapporteur());
            soutenance.setSalle(updatedData.getSalle());
            soutenance.setHeure(updatedData.getHeure());
            soutenance.setDate(updatedData.getDate());
            return soutenanceRepository.save(soutenance);
        }).orElseThrow(() -> new RuntimeException("Soutenance non trouvée !"));
    }

    //  Récupérer toutes les soutenances
    public List<Soutenance> getAllSoutenances() {
        return soutenanceRepository.findAll();
    }
}
