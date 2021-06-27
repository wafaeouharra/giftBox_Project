package com.example.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Produit {
    private int idProduit;
    private String libelle;
    private String marque;
    private double prix;
    private String image;
    private String description;
    private byte disponibilite;
    private int qteStock;
    private Date datePub;
    private int idCategorie;

    @Id
    @Column(name = "id_produit")
    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "marque")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
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
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "disponibilite")
    public byte getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(byte disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Basic
    @Column(name = "qte_stock")
    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    @Basic
    @Column(name = "date_pub")
    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    @Basic
    @Column(name = "id_categorie")
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (idProduit != produit.idProduit) return false;
        if (Double.compare(produit.prix, prix) != 0) return false;
        if (disponibilite != produit.disponibilite) return false;
        if (qteStock != produit.qteStock) return false;
        if (idCategorie != produit.idCategorie) return false;
        if (libelle != null ? !libelle.equals(produit.libelle) : produit.libelle != null) return false;
        if (marque != null ? !marque.equals(produit.marque) : produit.marque != null) return false;
        if (image != null ? !image.equals(produit.image) : produit.image != null) return false;
        if (description != null ? !description.equals(produit.description) : produit.description != null) return false;
        if (datePub != null ? !datePub.equals(produit.datePub) : produit.datePub != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idProduit;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) disponibilite;
        result = 31 * result + qteStock;
        result = 31 * result + (datePub != null ? datePub.hashCode() : 0);
        result = 31 * result + idCategorie;
        return result;
    }
}
