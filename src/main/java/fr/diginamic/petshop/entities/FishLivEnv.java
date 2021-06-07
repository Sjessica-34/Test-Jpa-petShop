package fr.diginamic.petshop.entities;

public enum FishLivEnv {
    FRESH_WATER("FRESH_WATER"),
    SEA_WATER("SEA_WATER");

    private String libelle;

    FishLivEnv(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}