package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.outils.ArbreBinaire;
import sample.outils.Noeud;

public class StatController {

    public ArbreBinaire a;
    @FXML public TextField rechercheText;
    @FXML public Text nbKm;
    @FXML public Text nomJoueur;
    @FXML public Text nbTotal;

   // Initilise le controlleur
   public void init(ArbreBinaire a) {
       this.a = a;
       this.nbTotal.setText("Il y a eu " + a.Taille()+ " parties jouées");
   }

   // Permet de recherche dans l'arbre un nombre de kilomètre
   public void recherche() {
       try {
           Noeud n = this.a.Recherche(Integer.parseInt(rechercheText.getText()));

           if(n != null)
           {
               System.out.println("fef");
               this.nbKm.setText(n.valeur + "");
               this.nomJoueur.setText(n.nomJoueur);
           }
       } catch (NumberFormatException e) {
           rechercheText.setText("");
       }

   }
}
