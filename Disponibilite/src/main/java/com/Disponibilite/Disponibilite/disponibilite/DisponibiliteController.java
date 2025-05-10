package com.Disponibilite.Disponibilite.disponibilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disponibilites")
public class DisponibiliteController {

    @Autowired
    private DisponibiliteService disponibiliteService;

    @PostMapping
    public ResponseEntity<disponibiilteModel> createDisponibilite(@RequestBody disponibilteDto dao) {
        disponibiilteModel disponibilite = disponibiliteService.createDisponibilite(dao);
        return new ResponseEntity<>(disponibilite, HttpStatus.CREATED);
    }

    @PostMapping("/{disponibiliteId}/enseignants/{enseignantId}")
    public ResponseEntity<disponibiilteModel> addEnseignantToDisponibilite(@PathVariable Long disponibiliteId, @PathVariable Long enseignantId) {
        disponibiilteModel disponibiilte = disponibiliteService.addEnseignantToDisponibilite(disponibiliteId, enseignantId);
        return new ResponseEntity<>(disponibiilte, HttpStatus.OK);
    }

    @DeleteMapping("/{disponibiliteId}/enseignants/{enseignantId}")
    public ResponseEntity<disponibiilteModel> removeEnseignantFromDisponibilite(
            @PathVariable Long disponibiliteId,
            @PathVariable Long enseignantId) {
        disponibiilteModel updatedDisponibilite = disponibiliteService.removeEnseignantFromDisponibilite(disponibiliteId, enseignantId);
        return ResponseEntity.ok(updatedDisponibilite);
    }
    @GetMapping
    public List<disponibiilteModel> getAllDisponibilites() {
        return disponibiliteService.getAllDisponibilites();
    }

    @GetMapping("/{id}")
    public ResponseEntity<disponibiilteModel> getDisponibiliteById(@PathVariable Long id) {
        Optional<disponibiilteModel> disponibiilte = disponibiliteService.getDisponibiliteById(id);
        return disponibiilte.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisponibilite(@PathVariable Long id) {
        disponibiliteService.deleteDisponibilite(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<disponibilteDto> updateDisponibilite(@PathVariable Long id, @RequestBody disponibilteDto disponibiliteDto) {
        try {
            // Call service to update the Disponibilite model
            disponibilteDto updatedDisponibilite = disponibiliteService.updateDisponibilite(id, disponibiliteDto);

            // Return the updated DisponibiliteDto with 200 OK status
            return new ResponseEntity<>(updatedDisponibilite, HttpStatus.OK);
        } catch (RuntimeException e) {
            // Handle errors (if not found or any other issues)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
