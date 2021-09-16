package modelo;

public class Producto {
    int id;
    String nom;
    double pre;
    String cat;

    public Producto() {
    }

    public Producto(int id, String nom, double pre, String cat) {
        this.id = id;
        this.nom = nom;
        this.pre = pre;
        this.cat = cat;
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

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }


}
