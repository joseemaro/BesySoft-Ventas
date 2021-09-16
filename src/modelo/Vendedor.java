package modelo;

public class Vendedor {
    int id;
    String nom;
    double suel;

    public Vendedor() {
    }

    public Vendedor(int id, String nom, double suel) {
        this.id = id;
        this.nom = nom;
        this.suel = suel;
    }
    public double getSuel() {
        return suel;
    }

    public void setSuel(double suel) {
        this.suel = suel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
