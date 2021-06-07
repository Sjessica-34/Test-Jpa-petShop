package fr.diginamic.petshop.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PET_STORE")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String managerName;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.PERSIST)
    private Set<Animal> animals;

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinTable(name = "pet_store_product",
            joinColumns = @JoinColumn(name = "id_pet_store", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id")
    )
    private Set<Product> products;

    {
        products = new HashSet<>();
        animals = new HashSet<>();
    }

    public PetStore() {
    }

    public PetStore(Long id, String name, String managerName) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        if (products == null) {
            return;
        }
        this.products = products;
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        product.addPetStore(this);
    }

    public void addAnimal(Animal animal) {
        if (animal == null) {
            return;
        }
        animal.setPetStore(this);
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", address=" + address +
                ", animals=" + animals +
                ", products=" + products +
                '}';
    }
}