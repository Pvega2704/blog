package com.blog.controller;

import com.blog.domain.Usuarios;
import com.blog.service.UsuariosService;
//import com.blog.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = usuariosService.getUsuarios(false);
        model.addAttribute("usuarios", lista);
        model.addAttribute("totalUsuarioss", lista.size());
        return "/usuarios/listado";
    }

    @GetMapping("/eliminar/{idUsuarios}")
    public String eliminar(Usuarios usuarios) {
        usuariosService.delete(usuarios);
        return "redirect:/usuarios/listado";
    }

    @GetMapping("/modificar/{idUsuarios}")
    public String modificar(Usuarios usuarios, Model model) {
        usuarios = usuariosService.getUsuarios(usuarios);
        model.addAttribute("usuarios", usuarios);
        return "/usuarios/modifica";
    }

   // @Autowired
    //private FirebaseStorageService firebaseStorageService;

    //@PostMapping("/guardar")
   // public String guardar(Usuarios usuarios, @RequestParam("imagenFile") MultipartFile imagenFile) {
        //if (!imagenFile.isEmpty()) {//No esta vacio, nos pasan una imagen 
        
           // usuariosService.save(usuarios);
        
      //  String ruta = firebaseStorageService.cargaImagen(imagenFile,
             //   "usuarios",
               // usuarios.getIdUsuarios());
       // usuarios.setRutaImagen(ruta);
    }

   // usuariosService.save(usuarios);

//return "redirect:/usuarios/listado";
 //   }

