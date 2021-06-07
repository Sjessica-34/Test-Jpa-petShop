package fr.diginamic.petshop.entities;

public enum ProdType {
    FOOD("Food"),
    ACCESSORY("Accessory"),
    CLEANING("Cleaning");

    private String libelle;

    ProdType(String libelle) {
        this.libelle = libelle;
    }

    public static ProdType getInstanceSaisonLibelle(String libelle) {
        ProdType[] saisons = ProdType.values();

        for (ProdType saison :
                saisons) {
            if (saison.getLibelle().equalsIgnoreCase(libelle)) {
                return saison;
            }
        }
        return null;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
