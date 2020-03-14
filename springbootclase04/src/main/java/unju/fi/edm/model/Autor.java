package unju.fi.edm.model;

import java.util.Objects;

public class Autor {
    private int dni;
    private String nombre;
    private String apellido;


    public Autor() {
    }

    public Autor(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Autor dni(int dni) {
        this.dni = dni;
        return this;
    }

    public Autor nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Autor apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Autor)) {
            return false;
        }
        Autor autor = (Autor) o;
        return dni == autor.dni && Objects.equals(nombre, autor.nombre) && Objects.equals(apellido, autor.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellido);
    }

    @Override
    public String toString() {
        return "{" +
            " dni='" + getDni() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            "}";
    }

}