package unju.fi.edm.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unju.fi.edm.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {	
	
	@Query("select u from Usuario u where (u.user = :user) and (u.contra = :contra)")
    public List<Usuario> buscarUsuario(String user, String contra);
	
}
