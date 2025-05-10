package com.Disponibilite.Disponibilite.disponibilite;


import com.Disponibilite.Disponibilite.Enseignant.EnseignantModel;
import com.Disponibilite.Disponibilite.Enseignant.EnseignantRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisponibiliteService {

    @Autowired
    private disponibilteRepo disponibiliteRepository;

    @Autowired
    private EnseignantRepo enseignantRepository;

    public disponibiilteModel createDisponibilite(disponibilteDto disponibiltedto) {
        disponibiilteModel disponibilite = new disponibiilteModel();
        disponibilite.setDate_dispo(disponibiltedto.getDate_dispo());
        return disponibiliteRepository.save(disponibilite);
    }

    @Transactional
    public disponibiilteModel addEnseignantToDisponibilite(Long disponibiliteId, Long enseignantId) {
        disponibiilteModel disponibilite = disponibiliteRepository.findById(disponibiliteId)
                .orElseThrow(() -> new RuntimeException("Disponibilité non trouvée"));

        EnseignantModel enseignant = enseignantRepository.findById(enseignantId)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé"));

        // Avoid duplicate additions
        if (!disponibilite.getEnseignants().contains(enseignant)) {
            disponibilite.getEnseignants().add(enseignant);
            enseignant.getDisponibilites().add(disponibilite); // Only if bidirectional
        }

        // Save only the owning side (if mapped correctly)
        return disponibiliteRepository.save(disponibilite);
    }
    @Transactional
    public disponibiilteModel removeEnseignantFromDisponibilite(Long disponibiliteId, Long enseignantId) {
        disponibiilteModel disponibilite = disponibiliteRepository.findById(disponibiliteId)
                .orElseThrow(() -> new RuntimeException("Disponibilité non trouvée"));

        EnseignantModel enseignant = enseignantRepository.findById(enseignantId)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé"));

        // Vérifier si l'enseignant est bien associé à cette disponibilité
        if (disponibilite.getEnseignants().contains(enseignant)) {
            disponibilite.getEnseignants().remove(enseignant);
            enseignant.getDisponibilites().remove(disponibilite); // Si bidirectionnel
        } else {
            throw new RuntimeException("L'enseignant n'est pas associé à cette disponibilité");
        }

        // Sauvegarder uniquement l'entité propriétaire
        return disponibiliteRepository.save(disponibilite);
    }

    public List<disponibiilteModel> getAllDisponibilites() {
        return disponibiliteRepository.findAll();
    }

    public Optional<disponibiilteModel> getDisponibiliteById(Long id) {
        return disponibiliteRepository.findById(id);
    }

    public void deleteDisponibilite(Long id) {
        disponibiliteRepository.deleteById(id);
    }
    public disponibilteDto updateDisponibilite(Long id, disponibilteDto dto) {
        // Find the existing 'disponibiliteModel' by ID
        disponibiilteModel existingDisponibiliteOpt = disponibiliteRepository.findById(id).orElseThrow(()->new RuntimeException("disponibilite not found"));
        disponibiilteModel disponibilite = new disponibiilteModel();
        disponibilite.setId(id);
        disponibilite.setDate_dispo(dto.getDate_dispo());
        disponibilite = disponibiliteRepository.save(disponibilite);
        disponibilteDto updatedDto = new disponibilteDto();;
        updatedDto.setDate_dispo(disponibilite.getDate_dispo());
        return updatedDto;
    }
}
