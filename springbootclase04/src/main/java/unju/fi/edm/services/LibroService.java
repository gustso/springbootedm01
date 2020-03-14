package unju.fi.edm.services;

import java.util.List;

//import com.unju.fi.edm.springbootclase03.components.ListadoLibros;
import unju.fi.edm.model.Libro;
import unju.fi.edm.repository.LibroRepository;

import org.springframework.stereotype.Service;

@Service
public class LibroService {
    private LibroRepository libroRepository;
    
    public LibroService(LibroRepository libroRepository) {
    	this.libroRepository = libroRepository;
    }


    public List<Libro> recuperarLibros() {        
        return libroRepository.buscarTodos();
    }

    public List<Libro> guardarLibro(Libro unLibro){
        //List<Libro> nuevoListado = listadoLibros.getListaDeLibros();
        //nuevoListado.add(unLibro);
        return libroRepository.findByNombreContaining(unLibro.getTitulo());
    }

}