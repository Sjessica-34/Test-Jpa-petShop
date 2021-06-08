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
        petStore.setName("L'arche de Noé");
        petStore.setManagerName("Jessica");
        em.persist(petStore);

        PetStore petStore2 = new PetStore();
        petStore2.setName("La ferme du Cantal");
        petStore2.setManagerName("Loïc");
        em.persist(petStore2);

        PetStore petStore3 = new PetStore();
        petStore3.setName("L'ami du cheval");
        petStore3.setManagerName("Victoria");
        em.persist(petStore3);

//        Création d'une nouvelle adresse
        Address address = new Address("12", "rue du zoo", "34130", "ZooCity");
 //       petStore.setAddress(address); OU
        address.changePetStore(petStore);
        em.persist(address);
        Address address2 = new Address("25", "rue de la ferme", "32548", "FarmVille");
        petStore.setAddress(address2);
        em.persist(address2);
        Address address3 = new Address("56", "avenue de l'hippodrome", "54652", "HorseTown");
        petStore.setAddress(address3);
        em.persist(address3);

//        Création d'un nouveau produit
        Product product = new Product("high-tech mess tin", "label", ProdType.ACCESSORY, 150.00);
        petStore.addProduct(product);
        Product product2 = new Product("chicken kibble", "label", ProdType.FOOD, 8.00);
        petStore.addProduct(product2);
        Product product3 = new Product(" cat shampoo", "label", ProdType.CLEANING, 6.00);
        petStore.addProduct(product3);

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
        cat.setChipId("CHIPID12");
        petStore.addAnimal(cat);

        Cat cat2 = new Cat();
        cat2.setBirth(new Date());
        cat2.setColor("black");
        cat2.setChipId("CHIPID23");
        petStore.addAnimal(cat2);

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

