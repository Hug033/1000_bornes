package sample.outils;

public class ArbreBinaire {
    Noeud racine;

    public  ArbreBinaire()
    {
        racine = null;
    }

    public void Afficher()
    {
        AfficherNoeud(racine, 0);
    }

    public boolean EstVide()
    {
        return (racine == null);
    }

    public void AfficherNoeud(Noeud n, int niveau)
    {
        String affichage = "";
        for (int i = 0; i < niveau; i++)
            affichage += " ";
        affichage += "|->" + n.valeur + ' ' + n.nomJoueur;
        System.out.println(affichage);
        if (n.filsGauche == null) {
            if (n.filsDroit != null)
                AfficherNoeud(n.filsDroit, niveau + 1);
        } else {
            AfficherNoeud(n.filsGauche, niveau + 1);
            if (n.filsDroit != null)
                AfficherNoeud(n.filsDroit, niveau + 1);
        }
    }

    public void Ajouter(int v, String j)
    {
        if (racine == null)
            racine = new Noeud(v, j);
        else
            AjouterNoeud(racine, v, j);
    }

    public void AjouterNoeud(Noeud r, int v, String j)
    {
        if(r.valeur >= v)
        {
            if(r.filsGauche == null)
                r.filsGauche = new Noeud(v, j);
            else
                AjouterNoeud(r.filsGauche, v, j);
        }
        else
        {
            if(r.filsDroit == null)
                r.filsDroit = new Noeud(v, j);
            else
                AjouterNoeud(r.filsDroit, v, j);
        }
    }

    public int Hauteur()
    {
        return HauteurNoeud(racine);
    }

    public int HauteurNoeud(Noeud n)
    {
        if(EstVide())
            return 0;
        else {
            if(n.filsDroit == null)
            {
                if(n.filsGauche == null)
                    return 1;
                else
                    return 1 + HauteurNoeud(n.filsGauche);
            } else {
                if(n.filsGauche != null)
                    return 1 + Math.max(HauteurNoeud(n.filsDroit), HauteurNoeud(n.filsGauche));
                else
                    return 1 + HauteurNoeud(n.filsDroit);
            }
        }
    }

    public int Taille()
    {
        return TailleNoeud(racine);
    }

    public int TailleNoeud(Noeud n)
    {
        if(EstVide())
            return 0;
        else {
            if(n.filsDroit == null)
            {
                if(n.filsGauche == null)
                    return 1;
                else
                    return 1 + TailleNoeud(n.filsGauche);
            } else {
                if(n.filsGauche != null)
                    return 1 + TailleNoeud(n.filsDroit) + TailleNoeud(n.filsGauche);
                else
                    return 1 + TailleNoeud(n.filsDroit);
            }
        }
    }

    public int Minimum()
    {
        if (racine == null)
            return -1;
        else
            return MinimumNoeud(racine);
    }

    public int MinimumNoeud(Noeud n)
    {
        if(n.filsGauche != null)
            return MinimumNoeud(n.filsGauche);
        else
            return n.valeur;
    }

    public int Maximum()
    {
        if (racine == null)
            return -1;
        else
            return MaximumNoeud(racine);
    }

    public int MaximumNoeud(Noeud n)
    {
        if (n.filsDroit == null) {
            return n.valeur;
        } else {
            return MaximumNoeud(n.filsDroit);
        }
    }

    public void ParcoursPrefixe()
    {
        System.out.print("[");
        ParcoursPrefixeNoeud(racine);
        System.out.println((racine == null ? "]" : "\b"));
    }

    public void ParcoursPrefixeNoeud(Noeud n)
    {
        System.out.print(n.valeur + ",");
        if (n.filsDroit == null) {
            if (n.filsGauche != null)
                ParcoursPrefixeNoeud(n.filsGauche);

        } else {
            if (n.filsGauche != null)
                ParcoursPrefixeNoeud(n.filsGauche);
            ParcoursPrefixeNoeud(n.filsDroit);
        }
    }

    public void ParcoursInfixe()
    {
        System.out.print("[");
        ParcoursInfixeNoeud(racine);
        System.out.println((racine == null ? "]" : "\b"));
    }

    public void ParcoursInfixeNoeud(Noeud n)
    {
        if (n.filsDroit == null) {
            if (n.filsGauche != null)
                ParcoursInfixeNoeud(n.filsGauche);
            System.out.print(n.valeur + ",");
        } else {
            if (n.filsGauche != null)
                ParcoursInfixeNoeud(n.filsGauche);
            System.out.print(n.valeur + ",");
            ParcoursInfixeNoeud(n.filsDroit);
        }
    }

    public void ParcoursSuffixe()
    {
        System.out.print("[");
        ParcoursSuffixeNoeud(racine);
        System.out.println((racine == null ? "]" : "\b"));
    }

    public void ParcoursSuffixeNoeud(Noeud n)
    {
        if (n.filsDroit == null) {
            if (n.filsGauche != null)
                ParcoursSuffixeNoeud(n.filsGauche);
            System.out.print(n.valeur + ",");
        } else {
            if (n.filsGauche != null)
                ParcoursSuffixeNoeud(n.filsGauche);
            ParcoursSuffixeNoeud(n.filsDroit);
            System.out.print(n.valeur + ",");
        }
    }

    // programme parcours en largeur
    public void ParcoursLargeur()
    {
        FileNoeud f = new FileNoeud();
        f.Enfiler(racine);

        System.out.print("[");
        while(!f.EstVide()) {
            Noeud n = f.Defiler();
            System.out.print(n.valeur+";");

            if (n.filsGauche != null) {
                f.Enfiler(n.filsGauche);
            }
            if (n.filsDroit != null) {
                f.Enfiler(n.filsDroit);
            }
        }
        System.out.println((racine == null ? "]" : "\b"));
    }

    public Noeud Recherche(int v)
    {
        return (RechercheNoeud(racine, v));
    }

    public Noeud RechercheNoeud(Noeud n, int v)
    {
        if(n == null || n.valeur == v)
            return n;
        if(v < n.valeur)
            return RechercheNoeud(n.filsGauche, v);
        else
            return RechercheNoeud(n.filsDroit, v);
    }

    public int NbFeuille()
    {
        return NbFeuilleNoeud(racine);
    }

    public int NbFeuilleNoeud(Noeud n)
    {
        if(n == null)
            return 0;
        return 1 + NbFeuilleNoeud(n.filsDroit) + NbFeuilleNoeud(n.filsGauche);
    }
}
