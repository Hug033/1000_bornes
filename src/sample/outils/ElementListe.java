package sample.outils;

import sample.Carte;

public class ElementListe {

    private Carte valeur;
    private ElementListe suivant;

    ElementListe(Carte valeur, ElementListe suivant)
    {
        this.valeur = valeur;
        this.suivant = suivant;
    }

    public ElementListe(Carte v) {
        this.valeur = v;
    }

    public Carte getValeur() {
        return valeur;
    }

    public void setValeur(Carte valeur) {
        this.valeur = valeur;
    }

    public ElementListe getSuivant() {
        return suivant;
    }

    public void setSuivant(ElementListe suivant) {
        this.suivant = suivant;
    }
}
