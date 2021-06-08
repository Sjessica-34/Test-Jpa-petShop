package fr.diginamic.petshop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;
    private Double price;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    private Set<PetStore> petStores;

    {
        petStores = new HashSet<>();
    }

    public Product() {
    }

    public Product(String code, String label, ProdType type, Double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Product(Long id, String code, String label, Double price, Set<PetStore> petStores) {
        this.id = id;
        this.code = code;
        this.label = label;
        this.price = price;
        this.petStores = petStores;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        if (petStores == null) {
            return;
        }
        this.petStores = petStores;
    }

    public void addPetStore(PetStore petStore) {
        if (petStore != null) {
            petStore.addProduct(this); // le reste en caché dans add product

        }
    }

    public void removePetStore(PetStore petStore) {
        if (petStore != null) {
            petStore.removeProduct(this);
        }
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
