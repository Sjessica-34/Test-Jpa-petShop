package fr.diginamic.petshop.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date birth;
    private String color;

    @ManyToOne
    @JoinColumn(name = "ID_STORE")
    private PetStore petStore;

    public Animal() {
    }

    public Animal(Long id, Date birth, String color, PetStore petStore) {
        this.id = id;
        this.birth = birth;
        this.color = color;
        this.petStore = petStore;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        if (this.petStore != null) {
            this.petStore.getAnimals().remove(this);
        }

        this.petStore = petStore;

        if (petStore != null) {
            petStore.getAnimals().add(this);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", color='" + color + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}

