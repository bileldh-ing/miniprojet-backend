package org.example.department.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String chefDeDepartement;

    // Constructeurs
    public Department() {}

    public Department(Long id, String name, String chefDeDepartement) {
        this.id = id;
        this.name = name;
        this.chefDeDepartement = chefDeDepartement;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChefDeDepartement() {
        return chefDeDepartement;
    }

    public void setChefDeDepartement(String chefDeDepartement) {
        this.chefDeDepartement = chefDeDepartement;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chefDeDepartement='" + chefDeDepartement + '\'' +
                '}';
    }
}
