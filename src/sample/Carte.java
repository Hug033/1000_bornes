package sample;

public class Carte {

    private String Nom; // Nom de la carte
    private int Type; // Les types de cartes peuvent être 'Attaques', 'Parades', 'Etapes'
    private int Km = 0; // Kilomètre de la carte si la carte est du type 'Etapes'
    private String NomImage; // Nom de l'image associé

    Carte(String Nom, int Type, String NomImage)
    {
        this.Nom = Nom;
        this.Type = Type;
        this.NomImage = NomImage;
    }

    Carte(String Nom, int Type, int Km, String NomImage)
    {
        this.Nom = Nom;
        this.Type = Type;
        this.Km = Km;
        this.NomImage = NomImage;
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

    // Rertourne le nom de l'image de la carte
    public String GetNomImage()
    {
        return this.NomImage;
    }
}
