public class Produit {
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    // Constructeur avec tous les attributs
    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructeur par défaut
    public Produit() {
    }

    // Getters et Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Calculer la valeur totale du produit
    public double calculerValeurTotale() {
        return quantite * prix;
    }

    // Méthode toString pour afficher les détails
    @Override
    public String toString() {
        return "Produit{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
