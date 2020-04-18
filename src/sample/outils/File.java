package sample.outils;

import sample.Carte;

public class File {
    private static int taille;
    private Carte[] tableau; // contenu de la pile
    private int entree, sortie;

    public File(int tailleParam) {
        this.taille = tailleParam;
        this.tableau = new Carte[taille];
        this.entree = this.sortie = 0;
    }

    boolean EstVide() {
        return (this.entree == this.sortie);
    }

    boolean EstPleine() {
        return ((this.sortie + 1) % taille == this.entree);
    }

    public void Enfiler(Carte e) {
        if (!EstPleine()) {
            this.tableau[sortie] = e;
            this.sortie = (sortie + 1) % taille;
        }
    }

    public Carte Defiler() {
        if (!EstVide()) {
            Carte c = this.tableau[entree];
            this.entree = (this.entree + 1) % taille;
            return (c);
        }
        return null;
    }

    public void Afficher()
    {
        for(int i = 0; i < this.tableau.length; i++)
            System.out.println(this.tableau[i].GetNom());
        System.out.println("-----------------");
    }
}
