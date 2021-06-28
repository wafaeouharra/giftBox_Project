package ma.ceft.Models;

import javax.persistence.*;

@Entity
@NamedQuery(name = "allUsers",query="SELECT u FROM User u")
@NamedQuery(name = "Login",query="SELECT us FROM User us WHERE us.nomUser= ?1 AND us.pwd= ?2")
public class User {
    private int idUser;
    private String nomUser;
    private String pwd;
    private byte active;
    private int idRole;

    @Id
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "nom_user")
    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "active")
    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Basic
    @Column(name = "id_role")
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (active != user.active) return false;
        if (idRole != user.idRole) return false;
        if (nomUser != null ? !nomUser.equals(user.nomUser) : user.nomUser != null) return false;
        if (pwd != null ? !pwd.equals(user.pwd) : user.pwd != null) return false;

        return true;
    }

    public User() {
    }

    public User(int idUser, String nomUser, String pwd, byte active, int idRole) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.pwd = pwd;
        this.active = active;
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (nomUser != null ? nomUser.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (int) active;
        result = 31 * result + idRole;
        return result;
    }
}
