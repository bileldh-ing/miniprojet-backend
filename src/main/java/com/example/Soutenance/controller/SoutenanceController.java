package com.example.Soutenance.controller;
import com.example.Soutenance.entity.Soutenance;
import com.example.Soutenance.service.SoutenanceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/soutenances")
public class SoutenanceController {
    private final SoutenanceService soutenanceService;

    public SoutenanceController(SoutenanceService soutenanceService) {
        this.soutenanceService = soutenanceService;
    }

    //  Importer un fichier CSV
    @PostMapping("/import")
    public String importSoutenances(@RequestParam("file") MultipartFile file) {
        try {
            soutenanceService.importFromCSV(file);
            return "Importation réussie !";
        } catch (IOException | CsvException e) {
            return "Erreur d'importation : " + e.getMessage();
        }
    }

    //  Ajouter une soutenance via formulaire
    @PostMapping
    public String addSoutenance(@RequestBody Soutenance soutenance) {
        soutenanceService.addSoutenance(soutenance);
        return "Importation réussie !";
    }

    // 📌 Mettre à jour une soutenance (après planification)
    @PutMapping("/{id}")
    public Soutenance updateSoutenance(@PathVariable Long id, @RequestBody Soutenance soutenance) {
        return soutenanceService.updateSoutenance(id, soutenance);
    }
    @GetMapping("/{id}")
    public Optional<Soutenance> getSoutenance(@PathVariable Long id) {
        return soutenanceService.getSoutenance(id);
    }
    @DeleteMapping("/{id}")
    public void deleteSoutenance(@PathVariable Long id) {
         soutenanceService.deleteSoutenance(id);
    }
    // 📌 Lister toutes les soutenances
    @GetMapping
    public List<Soutenance> getAllSoutenances() {
        return soutenanceService.getAllSoutenances();
    }
}
