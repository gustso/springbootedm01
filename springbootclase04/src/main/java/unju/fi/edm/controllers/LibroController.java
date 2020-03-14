package unju.fi.edm.controllers;

import java.util.List;

import javax.validation.Valid;

import com.unju.fi.edm.springbootclase03.model.Autor;
import com.unju.fi.edm.springbootclase03.model.Libro;
import com.unju.fi.edm.springbootclase03.services.LibroService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibroController {
    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @RequestMapping("/libros")
    public ModelAndView listarLibros(Model model) {
        // System.out.println("Prueba"+alumnoService.escribirDatos());
        List<Libro> libros = libroService.recuperarLibros();
        ModelAndView modelAndView = new ModelAndView("listaLibros");
        modelAndView.addObject("libros", libros);
        return modelAndView;
    }

    @GetMapping(path = { "/nuevoLibro" })
    public ModelAndView getFormPosteo() {
        ModelAndView modelAndView = new ModelAndView(("nuevoLibro"));
        modelAndView.addObject("libro", new Libro());
        // modelAndView.addObject("autor", new Autor());
        return modelAndView;
    }

    @PostMapping(path = { "/nuevoLibro" })
    public ModelAndView agregarNuevoLibro(@Valid Libro libro, Model model, BindingResult result) {
        // esto es manual y esta mal
        Autor unAutor = new Autor(698, "Gustavo", "Sosa");
        libro.setAutor(unAutor);
        // hasta aqui hay que cambiar
        // antes solo mandaba a la lista de libros (linea que sigue), en cambio con
        // setViewName valida el resultado
        // ModelAndView modelAndView = new ModelAndView("listaLibros");
        ModelAndView modelAndView = new ModelAndView();
        // se agrega un result para la validacion
        // modelAndView.setViewName(result.hasErrors() ? "nuevoLibro" : "listaLibros");

        // se agrega otra forma de validar, antes de guardar
        if (result.hasErrors()) {
            modelAndView.setViewName("nuevoLibro");
        } else {
            List<Libro> libros = libroService.guardarLibro(libro);
            modelAndView.addObject("libros", libros);
            modelAndView.setViewName("listaLibros");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/nuevoLibroDos")
    public ModelAndView agregarNuevoLibroDos(@Valid Libro libro, Model model, BindingResult result) {
        Autor unAutor = new Autor(698, "Gustavo", "Sosa");
        libro.setAutor(unAutor);
        ModelAndView modelAndView = new ModelAndView();
        
        if (result.hasErrors()) {
            modelAndView.setViewName("erroresTontos");
            modelAndView.addObject("libro", new Libro());            
            System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
            return modelAndView;
        }
        List<Libro> libros = libroService.guardarLibro(libro);        
        modelAndView.addObject("libros", libros);
        modelAndView.setViewName("listaLibros");        

        return modelAndView;
    }
    
    @RequestMapping(value = "/gustavo", method = RequestMethod.GET)
    public String mostrarFormLibro(Model model) {    	
    	model.addAttribute("libro", new Libro());
        return "nuevoLibro";
    }

    @RequestMapping(value = "/gustavo", method = RequestMethod.POST)
    public String agregarNuevoLibro(@ModelAttribute @Valid Libro libro, BindingResult result, Model model) {
        // esto es manual y esta mal
        Autor unAutor = new Autor(698, "Gustavo", "Sosa");
        libro.setAutor(unAutor);
        // hasta aqui hay que cambiar
        // antes solo mandaba a la lista de libros (linea que sigue), en cambio con
        // setViewName valida el resultado
        // ModelAndView modelAndView = new ModelAndView("listaLibros");
        
        // se agrega un result para la validacion
        // modelAndView.setViewName(result.hasErrors() ? "nuevoLibro" : "listaLibros");

        // se agrega otra forma de validar, antes de guardar
        if (result.hasErrors()) {
        	model.addAttribute("libro", new Libro());
        	System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"+result.getObjectName());
        	return "nuevoLibro";
        } 
        List<Libro> libros = libroService.guardarLibro(libro);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        model.addAttribute("libros", libros);        
        return "listaLibros";
    }

    
    
}