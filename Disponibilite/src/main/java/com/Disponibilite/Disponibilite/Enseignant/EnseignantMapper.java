package com.Disponibilite.Disponibilite.Enseignant;

import org.springframework.stereotype.Component;

@Component
public class EnseignantMapper {
    public EnseignantDto toDto(EnseignantModel model) {
        EnseignantDto dto = new EnseignantDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setEmail(model.getEmail());
        dto.setTel(model.getTel());
        dto.setGrade(model.getGrade());
        dto.setSpecialite(model.getSpecialite());
        return dto;
    }

    public EnseignantModel toModel(EnseignantDto dto) {
        EnseignantModel model = new EnseignantModel();
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setTel(dto.getTel());
        model.setGrade(dto.getGrade());
        model.setSpecialite(dto.getSpecialite());
        return model;
    }
}