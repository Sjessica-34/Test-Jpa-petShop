package fr.diginamic.petshop.entities;

import javax.persistence.*;

@Entity
@Table(name = "FISH")
public class Fish extends Animal {
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}