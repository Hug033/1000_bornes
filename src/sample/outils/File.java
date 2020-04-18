package sample.outils;

public class File {
    private static int taille = 10;
    private int[] tableau;
    private int entree, sortie;

    File() {
        this.tableau = new int[taille];
        this.entree = this.sortie = 0;
    }

    boolean EstVide() {
        return (this.entree == this.sortie);
    }

    boolean EstPleine() {
        return ((this.sortie + 1) % taille == this.entree);
    }

    public void Enfiler(int e) {
        if (!EstPleine()) {
            this.tableau[sortie] = e;
            this.sortie = (sortie + 1) % taille;
        }
    }

    public int Defiler() {
        if (!EstVide()) {
            int c = this.tableau[entree];
            this.entree = (this.entree + 1) % taille;
            return (c);
        }
        return 0;
    }

    public void Afficher()
    {
        for(int i = 0; i < this.tableau.length; i++)
            System.out.println(this.tableau[i]);
        System.out.println("-----------------");
    }
}
