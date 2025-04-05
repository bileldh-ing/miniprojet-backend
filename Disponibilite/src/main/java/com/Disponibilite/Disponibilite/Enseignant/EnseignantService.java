package com.Disponibilite.Disponibilite.Enseignant;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnseignantService {
    private final EnseignantRepo enseignantRepo;
    private final EnseignantMapper enseignantMapper;

    @Autowired
    public EnseignantService(EnseignantRepo enseignantRepo, EnseignantMapper enseignantMapper) {
        this.enseignantRepo = enseignantRepo;
        this.enseignantMapper = enseignantMapper;
    }

    public List<EnseignantDto> findAll() {
        return enseignantRepo.findAll()
                .stream()
                .map(enseignantMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<EnseignantDto> findAllPaginated(Pageable pageable) {
        return enseignantRepo.findAll(pageable)
                .map(enseignantMapper::toDto);
    }

    public EnseignantDto findById(Long id) {
        return enseignantMapper.toDto(enseignantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé avec l'ID : " + id)));
    }

    public EnseignantDto create(EnseignantDto enseignantDto) {
        if (enseignantRepo.existsByEmail(enseignantDto.getEmail())) {
            throw new RuntimeException("Un enseignant avec cet email existe déjà");
        }

        EnseignantModel enseignant = enseignantMapper.toModel(enseignantDto);
        return enseignantMapper.toDto(enseignantRepo.save(enseignant));
    }

    public EnseignantDto update(Long id, EnseignantDto enseignantDto) {
        EnseignantModel existingEnseignant = enseignantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé avec l'ID : " + id));


        existingEnseignant.setName(enseignantDto.getName());
        existingEnseignant.setGrade(enseignantDto.getGrade());
        existingEnseignant.setEmail(enseignantDto.getEmail());
        existingEnseignant.setSpecialite(enseignantDto.getSpecialite());
        existingEnseignant.setTel(enseignantDto.getTel());


        return enseignantMapper.toDto(enseignantRepo.save(existingEnseignant));
    }


    public void delete(Long id) {
        if (!enseignantRepo.existsById(id)) {
            throw new RuntimeException("Enseignant non trouvé avec l'ID : " + id);
        }
        enseignantRepo.deleteById(id);
    }
}