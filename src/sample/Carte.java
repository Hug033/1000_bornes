package sample;

public class Carte {

    private String Nom; // Nom de la carte
    private int Type; // Les types de cartes peuvent être 'Attaques', 'Parades', 'Etapes'
    private int Km = 0; // Kilomètre de la carte si la carte est du type 'Etapes'

    Carte(){}

    Carte(String Nom, int Type)
    {
        this.Nom = Nom;
        this.Type = Type;
    }

    Carte(String Nom, int Type, int Km)
    {
        this.Nom = Nom;
        this.Type = Type;
        this.Km = Km;
    }

    // Retourne le type d'une carte
    public int GetType()
    {
        return this.Type;
    }

    // Retourne le nombre de km (0 si il ne s'agit pas d'un carte 'Etapes')
    public int GetKm()
    {
        return this.Km;
    }

    // Rertourne le nom de la carte
    public String GetNom()
    {
        return this.Nom;
    }
}
