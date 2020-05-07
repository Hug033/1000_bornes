package sample.outils;

import sample.Carte;

public class Liste {
    private ElementListe premier;

    public ElementListe getPremier() {
        return premier;
    }

    public int getLongueur() // Complexité O(n)
    {
        ElementListe ElementCourant = this.getPremier();
        int compteur = 0;
        while (ElementCourant != null) {
            compteur++;
            ElementCourant = ElementCourant.getSuivant();
        }
        return compteur;
    }

    public boolean contient(Carte value) // Complexité O(n)
    {
        ElementListe ElementCourant = this.getPremier();
        while (ElementCourant != null) {
            if (ElementCourant.getValeur() == value)
                return true;
            ElementCourant = ElementCourant.getSuivant();
        }
        return false;
    }

    public void retirerPremiereOccurrence_R(Carte v){
        if (getLongueur() != 0)
        {
            premier=retirerPremiereOccurrence_Rec(premier,v);
        }
    }
    public ElementListe retirerPremiereOccurrence_Rec(ElementListe l, Carte v) {
        ElementListe retour=l;
        if (l!=null)
        {
            if (l.getValeur() == v) {
                retour= l.getSuivant();
            }
            else {
                l.setSuivant(retirerPremiereOccurrence_Rec(l.getSuivant(), v));
            }
        }
        return retour;
    }

    public int getLongueurRecur(ElementListe ElementCourant) // Complexité O(n)
    {
        if (ElementCourant.getSuivant() == null)
            return 1;
        else
            return 1 + getLongueurRecur(ElementCourant.getSuivant());
    }

    public boolean contientRecur(ElementListe ElementCourant, Carte value) // Complexité O(n) au pire
    {
        if (ElementCourant == null)
            return false;
        else if (ElementCourant != null && ElementCourant.getValeur() == value)
            return true;
        else
            return contientRecur(ElementCourant.getSuivant(), value);
    }


    public void ajouterAuDebut(Carte v) {
        ElementListe ancienPremier = premier;
        premier = new ElementListe(v, ancienPremier);
    }

    public Carte Minimum()
    {
        ElementListe ElementCourant = this.getPremier();
        Carte min = ElementCourant.getValeur();
        while (ElementCourant != null) {
            if(min.GetType() > ElementCourant.getValeur().GetType())
                min = ElementCourant.getValeur();
            ElementCourant = ElementCourant.getSuivant();
        }
        return min;
    }

    // COMPLEXITÉ O(n²) --> Permet de trier un liste par type de carte
    public Liste tri_Minimum() {
        Liste l = new Liste();
        while(getLongueur() > 0) {
            Carte min = Minimum();
            l.ajouterAuDebut(min);
            retirerPremiereOccurrence_R(min);
        }
        return l;
    }
}
