package unju.fi.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unju.fi.edm.model.Libro;

public interface LibroRepository extends JpaRepository <Libro, Integer> {
	
	@Query("from Libro l order by l.titulo")
	public List<Libro>buscarTodos();
	
	public List<Libro>findByTituloContaining(String titulo);
	
	
}
