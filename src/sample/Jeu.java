package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.outils.File;
import sample.outils.Pile;


public class Jeu extends Application {

    private Pile Pioche; // Pioche du jeu
    private File  Tas; // Tas du jeu
    private String Jeu; // Cartes du jeu
    private int[] Plateau; // Plateau du jeu
    private Joueur j1 = new Joueur(); // Joueur 1
    private Joueur j2 = new Joueur(); // Joueur 2
    private Joueur joeurSelectionne; // Joueur en train de jouer

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
        primaryStage.setTitle("1000 Bornes Hugo BOUILLARD");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    public Jeu() {
    }

    public void Initialiser()
    {
        if(this.Pioche != null)
            System.out.println("coucou");

        // Il faut construire le tableau avec toutes les cartes existantes dans le mille bornes
        Carte toutesCartes[] = new Carte[100]; // Il y a 100 cartes dans le jeu du mille bornes
        this.Pioche = new Pile(toutesCartes.length);


        // On ajoute les cartes 'Attaques' --> le type est 0

        // Ajout des cartes 'Feu rouge'
        Carte feuRouge = new Carte("Feu Rouge", 0);
        for (int i = 0; i < 4; i++)
            toutesCartes[i] = feuRouge;

        // Ajout des cartes 'Limitation de vitesse'
        Carte vitesse = new Carte("Limitation de vitesse", 0);
        for (int i = 4; i < 7; i++)
            toutesCartes[i] = vitesse;

        // Ajout des cartes 'Panne sèche'
        Carte panne = new Carte("Panne sèche", 0);
        for (int i = 7; i < 10; i++)
            toutesCartes[i] = panne;

        // Ajout des cartes 'Crevaison'
        Carte crevaison = new Carte("Crevaison", 0);
        for (int i = 10; i < 13; i++)
            toutesCartes[i] = crevaison;

        // Ajout des cartes 'Accident'
        Carte accident = new Carte("Accident", 0);
        for (int i = 13; i < 16; i++)
            toutesCartes[i] = accident;



        // On ajoute maintenant les cartes 'Parades' --> Type 1

        // Ajout des cartes 'Feu vert'
        Carte feuVert = new Carte("Feu vert", 1);
        for (int i = 16; i < 30; i++)
            toutesCartes[i] = feuVert;

        // Ajout des cartes 'Fin de limitation'
        Carte finDeLimitation = new Carte("Fin de limitation", 1);
        for (int i = 30; i < 36; i++)
            toutesCartes[i] = finDeLimitation;

        // Ajout des cartes 'Essence'
        Carte essence = new Carte("Essence", 1);
        for (int i = 36; i < 42; i++)
            toutesCartes[i] = essence;

        // Ajout des cartes 'Roue de secours'
        Carte roueDeSecours = new Carte("Roue de secours", 1);
        for (int i = 42; i < 48; i++)
            toutesCartes[i] = roueDeSecours;

        // Ajout des cartes 'Depanneuse'
        Carte depanneuse = new Carte("Depanneuse", 1);
        for (int i = 48; i < 54; i++)
            toutesCartes[i] = depanneuse;

        // Pour finir on ajoute les cartes 'Etapes' --> Type 2

        // Ajout des cartes '25'
        Carte km25 = new Carte("25 Kms", 2, 25);
        for (int i = 54; i < 64; i++)
            toutesCartes[i] = km25;

        // Ajout des cartes '50'
        Carte km50 = new Carte("50 Kms", 2, 50);
        for (int i = 64; i < 74; i++)
            toutesCartes[i] = km50;

        // Ajout des cartes '75'
        Carte km75 = new Carte("75 Kms", 2, 75);
        for (int i = 74; i < 84; i++)
            toutesCartes[i] = km75;

        // Ajout des cartes '100'
        Carte km100 = new Carte("100 Kms", 2, 100);
        for (int i = 84; i < 96; i++)
            toutesCartes[i] = km100;

        // Ajout des cartes '200'
        Carte km200 = new Carte("200 Kms", 2, 200);
        for (int i = 96; i < 100; i++)
            toutesCartes[i] = km200;

        int compteur = 0;
        while(compteur != toutesCartes.length)
        {
            int randPos = ((int)(Math.random()*1000))%toutesCartes.length;
            Carte carte = toutesCartes[randPos];
            toutesCartes[randPos] = null;
            if(carte != null)
            {
                Pioche.Empiler(carte);
                compteur++;
            }
        }
        //Pioche.Afficher();
        Distribuer();
    }

    // Distribue les 7 cartes de chaque joueur
    public void Distribuer()
    {
        for(int i = 0; i < 7; i++)
        {
            j1.Main.ajouterAuDebut(Piocher());
            j2.Main.ajouterAuDebut(Piocher());
        }
    }

    // Retirer une carte de la pioche et la retourne
    public Carte Piocher()
    {
        return Pioche.Depiler();
    }

    public void VerifierGagnant()
    {

    }

    public void JoueurSuivant() {

    }
}
