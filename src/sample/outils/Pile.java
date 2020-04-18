package sample.outils;

import sample.Carte;
import sample.Joueur;

public class Pile {
    private Carte[] tab; // contenu de la pile
    private int Sommet; //position du sommet
    private int tailleMax;

    public void Afficher() {
    // On a accès à tab, donc parcours du tableau classiquement
        for (int i = Sommet; i >= 0; i--)
            System.out.print(tab[i].GetNom() + " ");
        System.out.println("-");
    }

    public Pile() {}

    // constructeur
    public Pile(int max) {
        setTailleMax(max);
        Sommet = -1;
        tab = new Carte[max];
    }

    // Ajout de v dans la pile au Sommet
    public void Empiler(Carte v) {
        if (Sommet <= (this.tailleMax - 1)) {
            Sommet++;
            tab[Sommet] = v;
        }
    }

    // Suppression du dernier élément empilé (au sommet)
    public Carte Depiler() {
        Carte val = null;
        if (!this.Est_vide()) {
            val = tab[Sommet];
            Sommet--;
        }
        return val;
    }

    boolean Est_vide() {
        return (Sommet == -1);
    }

    public int getTailleMax() {
        return tailleMax;
    }

    public void setTailleMax(int tailleMax) {
        this.tailleMax = tailleMax;
    }
}