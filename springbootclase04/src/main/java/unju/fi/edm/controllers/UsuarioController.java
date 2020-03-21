package unju.fi.edm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import unju.fi.edm.model.Usuario;
import unju.fi.edm.services.UsuarioService;

import java.util.List;

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
/**
    @PostMapping(path = {"/usuarioValidado"})
    public ModelAndView validarUsuario(Usuario usuario, Model model) {
        List<Usuario> usuarios = usuarioService.validarUsuario(usuario);
        String formulario = "";
        if (!usuarioService.validarUsuario(usuario).isEmpty()) {
            formulario = "formValidado";
        }
        ModelAndView modelAndView = new ModelAndView((formulario));
        try {
            modelAndView.addObject("usuario", usuarios.get(0));
        } catch (Exception e) {
            System.out.println("holaaaaaaaaaaaaaaaaaaaaaa"+e);
        }
        return modelAndView;
    }**/

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
}
