package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.outils.ElementListe;
import sample.outils.File;
import sample.outils.Pile;
import sample.outils.ArbreBinaire;

import java.io.IOException;

public class Jeu extends Application {

    // Déclaration de variables (@FXML est uniquement pour les variables JavaFX)

    public Pile Pioche; // Pioche du jeu
    public File Tas; // Tas du jeu
    public Joueur j1; // Joueur 1
    public Joueur j2; // Joueur Ordinateur
    public Carte carteSelectionne; // Carte selectionné par le joueur
    public Controller c = new Controller(); // Le controller contenant certaines fonctions
    public ArbreBinaire statistiques = new ArbreBinaire(); // Arbre des statistiques

    // Variable uniquement pour la gestion graphique
    @FXML
    public Text endText;
    @FXML
    public ProgressBar j1Progress;
    @FXML
    public ProgressBar j2Progress;
    @FXML
    public ImageView carte1;
    @FXML
    public ImageView carte2;
    @FXML
    public ImageView carte3;
    @FXML
    public ImageView carte4;
    @FXML
    public ImageView carte5;
    @FXML
    public ImageView carte6;
    @FXML
    public ImageView carte7;
    @FXML
    public Pane blurPane;
    @FXML
    public Button init;
    @FXML
    public ImageView carteMalus;

    // Démarrage du programme
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
        primaryStage.setTitle("1000 Bornes Hugo BOUILLARD");
        primaryStage.getIcons().add(new Image(Jeu.class.getResourceAsStream("images/logo.png")));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Initialise le jeu en ajoutant les cartes, en créant la pioche et en distribuant les cartes
    public void Initialiser() {
        if (this.Pioche != null)
            System.out.println("coucou");

        // On cache le button de démarrage ainsi que le flou
        blurPane.setVisible(false);
        init.setVisible(false);
        endText.setVisible(false);
        j1Progress.setProgress(0);
        j2Progress.setProgress(0);
        j1 = new Joueur("j1");
        j2 = new Joueur("j2");

        // Il faut construire le tableau avec toutes les cartes existantes dans le mille bornes
        Carte toutesCartes[] = new Carte[100]; // Il y a 100 cartes dans le jeu du mille bornes
        this.Pioche = new Pile(toutesCartes.length);
        this.Tas = new File(toutesCartes.length);

        // On ajoute les cartes 'Attaques' --> le type est 0

        // Ajout des cartes 'Feu rouge'
        Carte feuRouge = new Carte("Feu rouge", 0, "stop.png");
        for (int i = 0; i < 4; i++)
            toutesCartes[i] = feuRouge;

        // Ajout des cartes 'Limitation de vitesse'
        Carte vitesse = new Carte("Limitation de vitesse", 0, "limitation.png");
        for (int i = 4; i < 7; i++)
            toutesCartes[i] = vitesse;

        // Ajout des cartes 'Panne sèche'
        Carte panne = new Carte("Panne seche", 0, "panne.png");
        for (int i = 7; i < 10; i++)
            toutesCartes[i] = panne;

        // Ajout des cartes 'Crevaison'
        Carte crevaison = new Carte("Crevaison", 0, "creve.png");
        for (int i = 10; i < 13; i++)
            toutesCartes[i] = crevaison;

        // Ajout des cartes 'Accident'
        Carte accident = new Carte("Accident", 0, "accident.png");
        for (int i = 13; i < 16; i++)
            toutesCartes[i] = accident;


        // On ajoute maintenant les cartes 'Parades' --> Type 1

        // Ajout des cartes 'Feu vert'
        Carte feuVert = new Carte("Feu vert", 1, "partez.png");
        for (int i = 16; i < 30; i++)
            toutesCartes[i] = feuVert;

        // Ajout des cartes 'Fin de limitation'
        Carte finDeLimitation = new Carte("Fin de limitation", 1, "fin_limitation.png");
        for (int i = 30; i < 36; i++)
            toutesCartes[i] = finDeLimitation;

        // Ajout des cartes 'Essence'
        Carte essence = new Carte("Essence", 1, "essence.png");
        for (int i = 36; i < 42; i++)
            toutesCartes[i] = essence;

        // Ajout des cartes 'Roue de secours'
        Carte roueDeSecours = new Carte("Roue de secours", 1, "roue.png");
        for (int i = 42; i < 48; i++)
            toutesCartes[i] = roueDeSecours;

        // Ajout des cartes 'Depanneuse'
        Carte depanneuse = new Carte("Depanneuse", 1, "garage.png");
        for (int i = 48; i < 54; i++)
            toutesCartes[i] = depanneuse;

        // Pour finir on ajoute les cartes 'Etapes' --> Type 2

        // Ajout des cartes '25'
        Carte km25 = new Carte("25 Kms", 2, 25, "25.png");
        for (int i = 54; i < 64; i++)
            toutesCartes[i] = km25;

        // Ajout des cartes '50'
        Carte km50 = new Carte("50 Kms", 2, 50, "50.png");
        for (int i = 64; i < 74; i++)
            toutesCartes[i] = km50;

        // Ajout des cartes '75'
        Carte km75 = new Carte("75 Kms", 2, 75, "75.png");
        for (int i = 74; i < 84; i++)
            toutesCartes[i] = km75;

        // Ajout des cartes '100'
        Carte km100 = new Carte("100 Kms", 2, 100, "100.png");
        for (int i = 84; i < 96; i++)
            toutesCartes[i] = km100;

        // Ajout des cartes '200'
        Carte km200 = new Carte("200 Kms", 2, 200, "200.png");
        for (int i = 96; i < 100; i++)
            toutesCartes[i] = km200;

        int compteur = 0;
        while (compteur != toutesCartes.length) {
            int randPos = ((int) (Math.random() * 1000)) % toutesCartes.length;
            Carte carte = toutesCartes[randPos];
            toutesCartes[randPos] = null;
            if (carte != null) {
                Pioche.Empiler(carte);
                compteur++;
            }
        }
        //Pioche.Afficher();
        Distribuer();
    }

    // Distribue les 7 cartes de chaque joueur
    public void Distribuer() {
        // On ajoute 7 cartes dans la main des joueur
        for (int i = 0; i < 7; i++) {
            j1.Main.ajouterAuDebut(Piocher());
            j2.Main.ajouterAuDebut(Piocher());
        }
        TrierMain(); // On trie la main du joueur
        c.afficherCarteJoueur(this); // On affiche les cartes du joueur sur le plateau

        // On ajoute une carte malus a chaque joueur dans la pile des malus (il faut toujours un feu vert pour commencer au 1000 bornes)
        ajouterMalus(j1, new Carte("Feu rouge", 0, "stop.png"));
        ajouterMalus(j2, new Carte("Feu rouge", 0, "stop.png"));
    }

    // Retirer une carte de la pioche et la retourne
    public Carte Piocher() {
        return Pioche.Depiler(); // Dépile la pile de la pioche
    }

    // Permet d'ajouter un malus a un joueur (Pile de malus)
    public void ajouterMalus(Joueur j, Carte c) {
        if (j != null && c != null) {
            j.Malus.ajouterAuDebut(c);

            // Permet d'afficher la dernière carte malus du joueur sur le plateau
            carteMalus.setVisible(true);
            carteMalus.setImage(new Image("file:src/sample/images/" + c.GetNomImage()));
        }
    }

    // Vérifie si un joueur a gagné
    public void VerifierGagnant(boolean t) {
        if (j1.NbKilometre == 1000) {
            endText.setText("Vous avez gagné !!");
            blurPane.setVisible(true);
            init.setVisible(true);
            endText.setVisible(true);
            statistiques.Ajouter(1000, j1.id);
        } else if (j2.NbKilometre == 1000) {
            endText.setText("L'ordinateur est plus fort !!");
            blurPane.setVisible(true);
            init.setVisible(true);
            endText.setVisible(true);
            statistiques.Ajouter(1000, j2.id);
        } else if (t) {
            // S'il n'y a plus de cartes dans la pioche on prend le nombre de kilomètre le plus élévé
            if (j1.NbKilometre > j2.NbKilometre) {
                endText.setText("Vous avez gagné !!");
                blurPane.setVisible(true);
                init.setVisible(true);
                endText.setVisible(true);
                statistiques.Ajouter(j1.NbKilometre, j1.id);
            } else {
                endText.setText("L'ordinateur est plus fort !!");
                blurPane.setVisible(true);
                init.setVisible(true);
                endText.setVisible(true);
                statistiques.Ajouter(j2.NbKilometre, j2.id);
            }
        }
    }

    // Permet au joueur de piocher
    public void JouerPiocher() {
        if (carteSelectionne != null && !Pioche.Est_vide()) {
            Tas.Enfiler(carteSelectionne); // On ajoute la carte dans la file
            j1.Main.retirerPremiereOccurrence_R(carteSelectionne); // On la retire de la main
            j1.Main.ajouterAuDebut(Piocher()); // Puis l'on fais piocher le joueur
            TrierMain(); // On trie la main du joueur grace au tri minimum
            c.afficherCarteJoueur(this);
            c.resetSelection(this);
            VerifierGagnant(false);
            JouerOrdinateur();
        } else {
            VerifierGagnant(true);
        }
    }

    // Permet de trouver un carte selon le type dans la main de l'ordinateur (Récursif)
    private Carte trouverCarteParType(ElementListe e, int type) {
        if (e.getValeur() != null) {
            if (e.getValeur().GetType() == type)
                return e.getValeur();
            else if (e.getSuivant() != null)
                return trouverCarteParType(e.getSuivant(), type);
        }
        return null;
    }

    // Permet de trouver un carte par nom afin de la jouer (Récursif)
    private boolean trouverCarteParNom(ElementListe e, String nom) {
        if (e.getValeur() != null) {
            if (e.getValeur().GetNom() == nom) {
                OrdinateurPioche(e.getValeur());
                return true;
            } else if (e.getSuivant() != null)
                return trouverCarteParNom(e.getSuivant(), nom);
        }
        return false;
    }

    // Vérifie si les cartes parades sont jouables
    private Carte retirerMalus(Joueur j) {
        ElementListe temp = j.Malus.getPremier();
        do {
            if (j == j1) {
                if (carteSelectionne.GetNom() == "Feu vert" && temp.getValeur().GetNom() == "Feu rouge")
                    return temp.getValeur();
                else if (carteSelectionne.GetNom() == "Fin de limitation" && temp.getValeur().GetNom() == "Limitation de vitesse")
                    return temp.getValeur();
                else if (carteSelectionne.GetNom() == "Essence" && temp.getValeur().GetNom() == "Panne seche")
                    return temp.getValeur();
                else if (carteSelectionne.GetNom() == "Roue de secours" && temp.getValeur().GetNom() == "Crevaison")
                    return temp.getValeur();
                else if (carteSelectionne.GetNom() == "Depanneuse" && temp.getValeur().GetNom() == "Accident")
                    return temp.getValeur();
            } else {
                if (temp.getValeur().GetNom() == "Feu rouge" && trouverCarteParNom(j2.Main.getPremier(), "Feu vert"))
                    return temp.getValeur();
                else if (temp.getValeur().GetNom() == "Limitation de vitesse" && trouverCarteParNom(j2.Main.getPremier(), "Fin de limitation"))
                    return temp.getValeur();
                else if (temp.getValeur().GetNom() == "Panne seche" && trouverCarteParNom(j2.Main.getPremier(), "Essence"))
                    return temp.getValeur();
                else if (temp.getValeur().GetNom() == "Crevaison" && trouverCarteParNom(j2.Main.getPremier(), "Roue de secours"))
                    return temp.getValeur();
                else if (temp.getValeur().GetNom() == "Accident" && trouverCarteParNom(j2.Main.getPremier(), "Depanneuse"))
                    return temp.getValeur();
            }
            temp = temp.getSuivant(); // On passe à la carte suivante
        } while (temp != null && temp.getSuivant() != null);

        return null;
    }

    // Permet au joueur d'avancer, ou de mettre des malus a l'adversaire, ou de contrer une attaque
    public void Jouer() {
        if (carteSelectionne != null) {
            // Si le joueur a un malus et la carte sélectionné est une carte étape
            if (j1.Malus.getLongueur() != 0 && carteSelectionne.GetType() == 2)
                return;

                // Sinon si la carte est une carte malus en l'ajoute à la liste des malus de l'autre joueur
            else if (carteSelectionne.GetType() == 0)
                j2.Malus.ajouterAuDebut(carteSelectionne);

                // Sinon si la carte est une carte parade
            else if (carteSelectionne.GetType() == 1) {
                // On vérifie s'il y a des malus sinon les cartes parades ne sont pas jouables
                if (j1.Malus.getLongueur() == 0)
                    return; // Si il n'y a pas de cartes malus les cartes parades ne sont pas jouable
                else if (retirerMalus(j1) == null)
                    return; // Si il n'y a pas de cartes malus que correspond a la carte parade sélectionné l'action n'est pas jouable
                else {
                    j1.Malus.retirerPremiereOccurrence_R(retirerMalus(j1)); // On retire la carte malus qui correspond à la parade
                    if (j1.Malus.getLongueur() != 0)
                        carteMalus.setImage(new Image("file:src/sample/images/" + j1.Malus.getPremier().getValeur().GetNomImage()));
                    else
                        carteMalus.setVisible(false);
                }
            }

            // Sinon si la carte est un carte étape
            else if (carteSelectionne.GetType() == 2) {
                // Si le nombre de kilomètre est bien inférieur à 1000 alors on ajoute de kilomètre
                if (j1.NbKilometre + carteSelectionne.GetKm() <= 1000) {
                    j1.NbKilometre += carteSelectionne.GetKm();
                    j1Progress.setProgress(j1.NbKilometre / 1000.0);
                    VerifierGagnant(false);
                } else
                    return;
            }

            // On retire la carte jouer et on en ajoute une autre
            ElementListe temp = j1.Main.getPremier();
            do {
                if (temp.getValeur() != carteSelectionne) {
                    temp = temp.getSuivant();
                }
            } while (temp.getValeur() != carteSelectionne);
            Tas.Enfiler(temp.getValeur());
            j1.Main.retirerPremiereOccurrence_R(temp.getValeur());
            if (!Pioche.Est_vide())
                j1.Main.ajouterAuDebut(Piocher());
            else
                VerifierGagnant(true);
            TrierMain();
            c.afficherCarteJoueur(this);
            c.resetSelection(this);

            // On fait jouer l'ordinateur
            JouerOrdinateur();
        }
    }

    // Permet à l'ordinateur de jouer
    private void JouerOrdinateur() {
        Carte carteRobot;

        // Si l'ordinateur a des malus on essaye de les enlever
        if (j2.Malus.getLongueur() != 0 && (carteRobot = retirerMalus(j2)) != null) {
            j2.Malus.retirerPremiereOccurrence_R(carteRobot); // On retire la carte malus qui correspond à la parade
            return;
        }

        // Sinon si l'on a pas de malus et que l'on peut avancer on avance
        else if (j2.Malus.getLongueur() == 0 && trouverCarteParType(j2.Main.getPremier(), 2) != null) {
            carteRobot = trouverCarteParType(j2.Main.getPremier(), 2);
            if (j2.NbKilometre + carteRobot.GetKm() <= 1000) {
                j2.NbKilometre += carteRobot.GetKm();
                j2Progress.setProgress(j2.NbKilometre / 1000.0);
                OrdinateurPioche(carteRobot);
                VerifierGagnant(false);
            } else {
                OrdinateurPioche(carteRobot);
            }
        }

        // Sinon si l'on possede des attaques on bloque le joueur 1
        else if ((carteRobot = trouverCarteParType(j2.Main.getPremier(), 0)) != null) {
            ajouterMalus(j1, carteRobot);
            OrdinateurPioche(carteRobot);
        }

        // Sinon on pioche une carte
        else
            OrdinateurPioche(j2.Main.getPremier().getValeur());
    }

    // Retire une carte du robot pour l'ajouter et en pioche une nouvelle
    private void OrdinateurPioche(Carte c) {
        j2.Main.retirerPremiereOccurrence_R(c); // On retire la carte parade avant de l'envoyer
        if (!Pioche.Est_vide())
            j2.Main.ajouterAuDebut(Piocher());
        else
            VerifierGagnant(true);
    }

    // Permet de trier les cartes du joueur avec le tri minimum (code du tri dans la class Liste)
    // On affiche donc la main par type de cartes (Type 2 --> etape, ...)
    private void TrierMain() {
        j1.Main = j1.Main.tri_Minimum();
    }

    // Permet la gestion de la sélection des cartes sur le plateau

    // Sélectionne la carte 1
    public void select1() {
        carteSelectionne = j1.Main.getPremier().getValeur();
        c.flouterCarte(this);
        carte1.setOpacity(1.0);
    }

    // Sélectionne la carte 2
    public void select2() {
        carteSelectionne = j1.Main.getPremier().getSuivant().getValeur();
        c.flouterCarte(this);
        carte2.setOpacity(1.0);
    }

    // Sélectionne la carte 3
    public void select3() {
        carteSelectionne = j1.Main.getPremier().getSuivant().getSuivant().getValeur();
        c.flouterCarte(this);
        carte3.setOpacity(1.0);
    }

    // Sélectionne la carte 4
    public void select4() {
        carteSelectionne = j1.Main.getPremier().getSuivant().getSuivant().getSuivant().getValeur();
        c.flouterCarte(this);
        carte4.setOpacity(1.0);
    }

    // Sélectionne la carte 5
    public void select5() {
        carteSelectionne = j1.Main.getPremier().getSuivant().getSuivant().getSuivant().getSuivant().getValeur();
        c.flouterCarte(this);
        carte5.setOpacity(1.0);
    }

    // Sélectionne la carte 6
    public void select6() {
        carteSelectionne = j1.Main.getPremier().getSuivant().getSuivant().getSuivant().getSuivant().getSuivant().getValeur();
        c.flouterCarte(this);
        carte6.setOpacity(1.0);
    }

    // Sélectionne la carte 7
    public void select7() {
        carteSelectionne = j1.Main.getPremier().getSuivant().getSuivant().getSuivant().getSuivant().getSuivant().getSuivant().getValeur();
        c.flouterCarte(this);
        carte7.setOpacity(1.0);
    }

    // Permet d'afficher la page des statistiques
    public void afficherStats() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stats.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
            StatController c = fxmlLoader.getController();
            c.init(this.statistiques); // On lui donne l'arbre des statistiques
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.getIcons().add(new Image(Jeu.class.getResourceAsStream("images/logo.png")));
            stage.setTitle("1000 Bornes Hugo BOUILLARD - Stats");
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
