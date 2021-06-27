package com.example.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Client {
    private int idClient;
    private int idUser;
    private String nomClient;
    private String prenomClient;
    private String adresse;
    private String email;
    private int numeroTel;
    private Date regdate;

    @Id
    @Column(name = "id_client")
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "Id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "nom_client")
    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @Basic
    @Column(name = "prenom_client")
    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    @Basic
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "numero_tel")
    public int getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }

    @Basic
    @Column(name = "regdate")
    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (idUser != client.idUser) return false;
        if (numeroTel != client.numeroTel) return false;
        if (nomClient != null ? !nomClient.equals(client.nomClient) : client.nomClient != null) return false;
        if (prenomClient != null ? !prenomClient.equals(client.prenomClient) : client.prenomClient != null)
            return false;
        if (adresse != null ? !adresse.equals(client.adresse) : client.adresse != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (regdate != null ? !regdate.equals(client.regdate) : client.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + idUser;
        result = 31 * result + (nomClient != null ? nomClient.hashCode() : 0);
        result = 31 * result + (prenomClient != null ? prenomClient.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + numeroTel;
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
