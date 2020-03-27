package unju.fi.edm.model;

//import java.util.Objects;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;



@Entity
public class Libro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "isbn", updatable = false, nullable = false)
    //@Min(value = 100, message = "El ISBN debe ser mayor que 99") 
    //@Max(value = 1000, message = "el ISB debe ser menor a 1000")
    //@NotBlank @NotNull si fuera un primitivo o booleano
    private Integer isbn;
	@Column(name = "titulo")
    private String titulo;
	@Column(name = "fotoTapa")
    private String fotoTapa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_dni")
    private Autor autor;
    //@JoinTable(name = "libro_autor", joinColumns = {@JoinColumn(name = "isbn")}, inverseJoinColumns = {@JoinColumn(name = "dni")})
    


    public Libro() {
    }  

	public Libro(Integer isbn, String titulo, String fotoTapa, Autor autor) {
		super();
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
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((fotoTapa == null) ? 0 : fotoTapa.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (fotoTapa == null) {
			if (other.fotoTapa != null)
				return false;
		} else if (!fotoTapa.equals(other.fotoTapa))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", fotoTapa=" + fotoTapa + ", autor=" + autor + "]";
	}
    
      
}