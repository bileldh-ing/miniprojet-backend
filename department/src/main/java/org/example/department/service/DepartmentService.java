package org.example.department.service;


import org.example.department.entity.Department;
import org.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    // Ajouter un département
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    // Lire tous les départements
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    // Lire un département par ID
    public Optional<Department> getDepartmentById(Long id) {
        return repository.findById(id);
    }

    // Mettre à jour un département
    public Department updateDepartment(Long id, Department department) {
        return repository.findById(id)
                .map(dep -> {
                    dep.setName(department.getName());
                    dep.setChefDeDepartement(department.getChefDeDepartement());
                    return repository.save(dep);
                })
                .orElseThrow(() -> new RuntimeException("Département non trouvé"));
    }

    // Supprimer un département
    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }
}
