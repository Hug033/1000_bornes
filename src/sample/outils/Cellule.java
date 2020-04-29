package sample.outils;

public class Cellule {
    Noeud noeud;
    Cellule suivant;

    //Constructeur
    Cellule(Noeud n)
    {
        noeud = n;
        suivant = null;
    }
}