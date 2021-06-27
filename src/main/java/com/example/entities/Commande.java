package com.example.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Commande {
    private int idCommande;
    private Date dateCommande;
    private String etat;
    private int idClient;

    @Id
    @Column(name = "id_commande")
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    @Basic
    @Column(name = "date_commande")
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Basic
    @Column(name = "etat")
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Basic
    @Column(name = "id_client")
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (idCommande != commande.idCommande) return false;
        if (idClient != commande.idClient) return false;
        if (dateCommande != null ? !dateCommande.equals(commande.dateCommande) : commande.dateCommande != null)
            return false;
        if (etat != null ? !etat.equals(commande.etat) : commande.etat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCommande;
        result = 31 * result + (dateCommande != null ? dateCommande.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        result = 31 * result + idClient;
        return result;
    }
}
