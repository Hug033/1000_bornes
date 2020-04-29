package sample.outils;

public class FileNoeud {
    Cellule Premier;

    FileNoeud()
    {
        Premier = null;
    }

    boolean EstVide()
    {
        return (Premier == null) ? true : false;
    }

    void Enfiler(Noeud n)
    {
        if (Premier == null)
            Premier = new Cellule(n);
        else {
            Cellule c = Premier;
            while (c.suivant != null)
                c = c.suivant;
            c.suivant = new Cellule(n);
        }
    }

    Noeud Defiler()
    {
        Cellule ancienPremier = Premier;
        Premier = Premier.suivant;
        return ancienPremier.noeud;
    }

    Noeud Premier()
    {
        return Premier.noeud;
    }
}
