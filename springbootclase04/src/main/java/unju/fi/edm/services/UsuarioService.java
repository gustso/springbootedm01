package unju.fi.edm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import unju.fi.edm.model.Usuario;
import unju.fi.edm.repository.UsuarioRepository;

@Service
public class UsuarioService {
	UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {		
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> recuperarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public void agregarUsuario(Usuario unUsuario) {		
		usuarioRepository.save(unUsuario);
	}
	
	public void eliminarUsuario(Usuario unUsuario) {
		usuarioRepository.delete(unUsuario);
	}
	
	public void modificarUsuario(Usuario unUsuario) {
		usuarioRepository.saveAndFlush(unUsuario);
	}
	
	public Usuario buscarUsuario (Integer dni) {
		return usuarioRepository.getOne(dni);
	}
	
	public List<Usuario> validarUsuario(Usuario usuario) {
        return usuarioRepository.buscarUsuario(usuario.getUser(), usuario.getContra());

    }
}
