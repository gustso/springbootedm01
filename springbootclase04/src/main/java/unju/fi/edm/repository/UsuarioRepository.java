package unju.fi.edm.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unju.fi.edm.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	//public List<Usuario>findAll();
	
}
