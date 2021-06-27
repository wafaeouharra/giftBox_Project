package com.example.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categorie {
    private int idCategorie;
    private String nomCategorie;
    private String descriptionCat;

    @Id
    @Column(name = "id_categorie")
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Basic
    @Column(name = "nom_categorie")
    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Basic
    @Column(name = "description_cat")
    public String getDescriptionCat() {
        return descriptionCat;
    }

    public void setDescriptionCat(String descriptionCat) {
        this.descriptionCat = descriptionCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        if (idCategorie != categorie.idCategorie) return false;
        if (nomCategorie != null ? !nomCategorie.equals(categorie.nomCategorie) : categorie.nomCategorie != null)
            return false;
        if (descriptionCat != null ? !descriptionCat.equals(categorie.descriptionCat) : categorie.descriptionCat != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategorie;
        result = 31 * result + (nomCategorie != null ? nomCategorie.hashCode() : 0);
        result = 31 * result + (descriptionCat != null ? descriptionCat.hashCode() : 0);
        return result;
    }
}
