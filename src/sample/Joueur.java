package sample;

import sample.outils.Liste;

/*
La classe joueur pour chaque joueur contient une main (de carte), les malus en cours ainsi que son nom
 */
public class Joueur {

    public Liste Main = new Liste(); // Main du joueur
    public Liste Malus = new Liste(); // Malus du joueur
    public int NbKilometre = 0;
    public String id; // Nom du joueur
}
