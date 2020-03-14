package unju.fi.edm.model;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class Libro {
    @Min(value = 100, message = "El ISBN debe ser mayor que 99") 
    @Max(value = 1000, message = "el ISB debe ser menor a 1000")
    @NotNull
    private Integer isbn;
    private String titulo;
    private String fotoTapa;
    private Autor autor;


    public Libro() {
    }

    public Libro(Integer isbn, String titulo, String fotoTapa, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fotoTapa = fotoTapa;
        this.autor = autor;
    }

    public Integer getIsbn() {
        return this.isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFotoTapa() {
        return this.fotoTapa;
    }

    public void setFotoTapa(String fotoTapa) {
        this.fotoTapa = fotoTapa;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Libro isbn(int isbn) {
        this.isbn = isbn;
        return this;
    }

    public Libro titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Libro fotoTapa(String fotoTapa) {
        this.fotoTapa = fotoTapa;
        return this;
    }

    public Libro autor(Autor autor) {
        this.autor = autor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return isbn == libro.isbn && Objects.equals(titulo, libro.titulo) && Objects.equals(fotoTapa, libro.fotoTapa) && Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, titulo, fotoTapa, autor);
    }

    @Override
    public String toString() {
        return "{" +
            " isbn='" + getIsbn() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", fotoTapa='" + getFotoTapa() + "'" +
            ", autor='" + getAutor() + "'" +
            "}";
    }

}