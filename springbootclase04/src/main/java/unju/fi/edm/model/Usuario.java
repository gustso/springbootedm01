package unju.fi.edm.model;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dni", updatable = false, nullable = false)
    private Integer dni;
    @Column(name = "user", updatable = false, nullable = false)
    private String user;
    @Column(name = "contra", updatable = false, nullable = false)
    private String contra;


    public Usuario() {
    }

    public Usuario(Integer dni, String user, String contra) {
        this.dni = dni;
        this.user = user;
        this.contra = contra;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
