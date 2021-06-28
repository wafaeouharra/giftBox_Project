package ma.ceft.Models;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllLigneCommandesPArCommande",query="SELECT lc FROM Lignecommande lc WHERE lc.idCommande = ?1")
public class Lignecommande {
    private int id;
    private int quantite;
    private double prix;
    private int idCommande;
    private int idProduit;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantite")
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Basic
    @Column(name = "prix")
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "id_commande")
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    @Basic
    @Column(name = "id_produit")
    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lignecommande that = (Lignecommande) o;

        if (id != that.id) return false;
        if (quantite != that.quantite) return false;
        if (Double.compare(that.prix, prix) != 0) return false;
        if (idCommande != that.idCommande) return false;
        if (idProduit != that.idProduit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + quantite;
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idCommande;
        result = 31 * result + idProduit;
        return result;
    }
}
