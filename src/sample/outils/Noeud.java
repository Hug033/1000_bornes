package sample.outils;

public class Noeud {
    public int valeur;
    public String nomJoueur;
    Noeud filsGauche, filsDroit;

    Noeud(int v, String j)
    {
        valeur = v;
        nomJoueur = j;
        filsGauche = filsDroit = null;
    }
}