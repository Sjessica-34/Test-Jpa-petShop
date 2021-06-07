package fr.diginamic.petshop.tests;

import fr.diginamic.petshop.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class TestPets {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");
        EntityManager em = emf.createEntityManager();
        System.out.println("connected on db");
        em.getTransaction().begin();

//       Création d'un nouveau Petstore
        PetStore petStore = new PetStore();
        petStore.setName("L'arche de Noé");
        petStore.setManagerName("Jessica");
//        em.persist(petStore);

//        Création d'une nouvelle adresse
        Address address = new Address("12", "rue du zoo", "34130", "ZooCity");
        address.setPetStore(petStore);
//        em.persist(address);
        petStore.setAddress(address);

//        Création d'un nouveau produit
        Product product = new Product("gamelle high-tech", "label", ProdType.valueOf("FOOD"), 150.00);
        product.setType(ProdType.valueOf("FOOD"));
        product.addPetStore(petStore);
        petStore.addProduct(product);
//        em.persist(product);

//        Insertion d'un nouveau poisson
        Fish fish = new Fish();
        fish.setBirth(new Date());
        fish.setColor("bleu");
        fish.setLivingEnv(FishLivEnv.SEA_WATER);
        fish.setPetStore(petStore);

//        Insertion d'un nouveau poisson
        Cat cat = new Cat();
        cat.setBirth(new Date());
        cat.setColor("gris");
        cat.setChipId("CHIPID");
        cat.setPetStore(petStore);

        petStore.addAnimal(fish);
        petStore.addAnimal(cat);
        em.persist(petStore);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

