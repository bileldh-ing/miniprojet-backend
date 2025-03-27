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

    // Ajout manuel via formulaire
    public Soutenance addSoutenance(Soutenance soutenance) {
        return soutenanceRepository.save(soutenance);
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
