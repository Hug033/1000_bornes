package sample;

import javafx.scene.image.Image;
import sample.outils.ElementListe;

public class Controller {

    /*

    Cette class controler permet de gérer en l'affichage du plateau

     */
    public Controller() {}

    // Permet de flouter les cartes
    public void flouterCarte(Jeu j)
    {
        j.carte1.setOpacity(0.5);
        j.carte2.setOpacity(0.5);
        j.carte3.setOpacity(0.5);
        j.carte4.setOpacity(0.5);
        j.carte5.setOpacity(0.5);
        j.carte6.setOpacity(0.5);
        j.carte7.setOpacity(0.5);
    }

    // Permet de mettre a jour l'affichage des cartes sur le plateau
    public void afficherCarteJoueur(Jeu j)
    {
        ElementListe temp = j.j1.Main.getPremier();
        int compteur = 0;
        while(temp != null)
        {
            if(compteur == 0){
                j.carte1.setImage(new Image("file:src/sample/images/" + temp.getValeur().GetNomImage()));
                compteur++;
            } else if (compteur == 1) {
                j.carte2.setImage(new Image("file:src/sample/images/" + temp.getValeur().GetNomImage()));
                compteur++;
            } else if (compteur == 2) {
                j.carte3.setImage(new Image("file:src/sample/images/" + temp.getValeur().GetNomImage()));
                compteur++;
            } else if (compteur == 3) {
                j.carte4.setImage(new Image("file:src/sample/images/" + temp.getValeur().GetNomImage()));
                compteur++;
            } else if (compteur == 4) {
                j.carte5.setImage(new Image("file:src/sample/images/" + temp.getValeur().GetNomImage()));
                compteur++;
            } else if (compteur == 5) {
                j.carte6.setImage(new Image("file:src/sample/images/" + temp.getValeur().GetNomImage()));
                compteur++;
            } else if (compteur == 6) {
                j.carte7.setImage(new Image("file:src/sample/images/" + temp.getValeur().GetNomImage()));
                compteur++;
            }
            temp = temp.getSuivant();
        }
    }

    // Rafraichis l'affichage des cartes du plateau
    public void resetSelection(Jeu j) {
        j.carte1.setOpacity(1);
        j.carte2.setOpacity(1);
        j.carte3.setOpacity(1);
        j.carte4.setOpacity(1);
        j.carte5.setOpacity(1);
        j.carte6.setOpacity(1);
        j.carte7.setOpacity(1);
        j.carteSelectionne = null;
    }

}
