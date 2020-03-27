package unju.fi.edm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import unju.fi.edm.model.Usuario;
import unju.fi.edm.services.UsuarioService;

import java.util.List;

import javax.validation.Valid;

@Controller
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/login")
    public ModelAndView login(Model model) {
        ModelAndView modelAndView = new ModelAndView(("formLogin"));
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }

    @PostMapping(path = {"/usuarioValidado"})
    public ModelAndView validarUsuario(Usuario usuario, Model model) {
        List<Usuario> usuarios = usuarioService.validarUsuario(usuario);
        String formulario = "";
        if (!usuarioService.validarUsuario(usuario).isEmpty()) {            
            formulario = "formListadoUsuarios";
        }
        else {
        	formulario = "formLogin";
        }
        ModelAndView modelAndView = new ModelAndView((formulario));
        modelAndView.addObject("usuarios", usuarios);
        
        return modelAndView;
    }

    @RequestMapping("/listadoUsuarios")
    public ModelAndView listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.recuperarUsuarios();
        ModelAndView modelAndView = new ModelAndView(("formListadoUsuarios"));
        modelAndView.addObject("usuarios", usuarios);
        //model.addAttribute("usuarios", usuarios);
        return modelAndView;
        //otra forma
        //usuarioService.agregarUsuario(usuario);
        //List<Usuario> usuarios = usuarioService.buscarUsuarios();
        //model.addAttribute("usuarios", usuarios);
        //return "formValidado";
    }
    
    @GetMapping(path = { "/nuevoUsuario" })
    public ModelAndView crearNuevoUsuario() {
        ModelAndView modelAndView = new ModelAndView(("nuevoUsuario"));
        modelAndView.addObject("usuario", new Usuario());        
        return modelAndView;
    }

    @PostMapping(path = { "/nuevoUsuario" })
    public ModelAndView agregarNuevoLibro(@ModelAttribute @Valid Usuario usuario, Model model, BindingResult result) {        
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
        	modelAndView.addObject("usuario", usuario);
            modelAndView.setViewName("nuevoUsuario");
        } else {        
            usuarioService.agregarUsuario(usuario);
            List<Usuario> usuarios = usuarioService.recuperarUsuarios();
            modelAndView.addObject("usuarios", usuarios);
            modelAndView.setViewName("formListadoUsuarios");            
        }
        return modelAndView;
    }
    
    @PostMapping(path = { "/nuevoUsuarioDos" })
    public String agregarNuevoLibroDos (@ModelAttribute @Valid Usuario usuario, ModelMap model, BindingResult result) {        
        if (result.hasErrors()) {
        	model.addAttribute("usuario", usuario);
        	return "nuevoUsuario";
        }         
            usuarioService.agregarUsuario(usuario);
            List<Usuario> usuarios = usuarioService.recuperarUsuarios();
            model.addAttribute("usuarios", usuarios);
                        
        
        return "formListadoUsuarios";
    }
    
    
    @GetMapping(path = { "/eliminarUsuario/{dni}" })
    public ModelAndView eliminarUsuario(@PathVariable (name = "dni") Integer dni) {
    	Usuario usuario = usuarioService.buscarUsuario(dni);
    	usuarioService.eliminarUsuario(usuario);
        ModelAndView modelAndView = new ModelAndView(("formListadoUsuarios"));        
        List<Usuario> usuarios = usuarioService.recuperarUsuarios();
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;
    }
    
    @GetMapping(path = { "/modificarUsuario/{dni}" })
    public ModelAndView modificarUsuario(@PathVariable (name = "dni") Integer dni) {    	
    	Usuario usuarioModificar = usuarioService.buscarUsuario(dni);    	
        ModelAndView modelAndView = new ModelAndView(("nuevoUsuario"));        
        modelAndView.addObject("usuario", usuarioModificar);
        return modelAndView;
    }
}
