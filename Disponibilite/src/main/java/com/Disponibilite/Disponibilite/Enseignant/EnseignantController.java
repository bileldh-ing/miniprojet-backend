package com.Disponibilite.Disponibilite.Enseignant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {
    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping
    public ResponseEntity<List<EnseignantDto>> getAllEnseignants() {
        return ResponseEntity.ok(enseignantService.findAll());
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<EnseignantDto>> getAllEnseignantsPaginated(Pageable pageable) {
        return ResponseEntity.ok(enseignantService.findAllPaginated(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnseignantDto> getEnseignantById(@PathVariable Long id) {
        return ResponseEntity.ok(enseignantService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnseignantDto> createEnseignant(@Valid @RequestBody EnseignantDto enseignantDto) {
        return new ResponseEntity<>(enseignantService.create(enseignantDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnseignantDto> updateEnseignant(
            @PathVariable Long id,
            @Valid @RequestBody EnseignantDto enseignantDto) {
        return ResponseEntity.ok(enseignantService.update(id, enseignantDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnseignant(@PathVariable Long id) {
        enseignantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}