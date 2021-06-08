package fr.diginamic.petshop.tests;

import fr.diginamic.petshop.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class TestPets {


//    private static final String FIND_ANIMALS_BY_PETSTORE = "SELECT a FROM Animal a WHERE a.petStore.id = ?1 ";

    private static final String FIND_ANIMALS_BY_PETSTORE2 = "SELECT a FROM Animal a WHERE a.petStore.id = :id_petstore";

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");
        EntityManager em = emf.createEntityManager();
        System.out.println("connected on db");
        em.getTransaction().begin();

//       Création d'un nouveau Petstore
        PetStore petStore = new PetStore();
//      PetStore petStore2 = new PetStore();
//      PetStore petStore3 = new PetStore();

        petStore.setName("L'arche de Noé");
        petStore.setManagerName("Jessica");


//        Création d'une nouvelle adresse
        Address address = new Address("12", "rue du zoo", "34130", "ZooCity");
        petStore.setAddress(address);


//        Création d'un nouveau produit
        Product product = new Product("gamelle high-tech", "label", ProdType.FOOD, 150.00);
        petStore.addProduct(product);

//        Insertion d'un nouveau poisson
        Fish fish = new Fish();
        fish.setBirth(new Date());
        fish.setColor("bleu");
        fish.setLivingEnv(FishLivEnv.SEA_WATER);
        petStore.addAnimal(fish);

//        Insertion d'un nouveau chat
        Cat cat = new Cat();
        cat.setBirth(new Date());
        cat.setColor("gris");
        cat.setChipId("CHIPID");
        petStore.addAnimal(cat);

        em.persist(petStore);

        em.getTransaction().commit();

//        TypedQuery<Animal> query = em.createQuery(FIND_ANIMALS_BY_PETSTORE, Animal.class);
//        query.setParameter(1, petStore.getId());
//        List<Animal> listAnimal = query.getResultList();
//        System.out.println(listAnimal.get(0));

        TypedQuery<Animal> query = em.createQuery(FIND_ANIMALS_BY_PETSTORE2, Animal.class);
        query.setParameter("id_petstore", petStore.getId());
        List<Animal> listAnimal = query.getResultList();

        System.out.println(listAnimal);
        em.close();
        emf.close();
    }
}

