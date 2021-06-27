package com.example.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    private int idRole;
    private String nomRole;

    @Id
    @Column(name = "id_role")
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "nom_role")
    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (idRole != role.idRole) return false;
        if (nomRole != null ? !nomRole.equals(role.nomRole) : role.nomRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + (nomRole != null ? nomRole.hashCode() : 0);
        return result;
    }
}
