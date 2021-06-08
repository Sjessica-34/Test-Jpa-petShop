package fr.diginamic.petshop.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADRESS")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String number;
    private String street;
    private String zipCode;
    private String city;

    @OneToOne(mappedBy = "address")
    private PetStore petStore;

    public Address() {
    }

    public Address(Long id, String number, String street, String zipCode, String city, PetStore petStore) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.petStore = petStore;
    }

    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PetStore getPetStore() {
        return petStore;
    }


    public void setPetStore(PetStore petStore) {
//        if (petStore == null) {
//            this.petStore.setAddress(null);
//        } else {
//            petStore.setAddress(this);
//        }
        this.petStore = petStore;
    }

    //Nouvelle méthode cree par Loïc pour liaison one to one
    public void changePetStore(PetStore petStore) {
        if (petStore != null){
            petStore.setAddress(null);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}

