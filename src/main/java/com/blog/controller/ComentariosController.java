package com.blog.controller;

import com.blog.domain.Comentarios;
import com.blog.service.ComentariosService;
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
@RequestMapping("/comentarios")
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = comentariosService.getComentarios(false);
        model.addAttribute("comentarios", lista);
        model.addAttribute("totalComentarioss", lista.size());
        return "/comentarios/listado";
    }

    @GetMapping("/eliminar/{idComentarios}")
    public String eliminar(Comentarios comentarios) {
        comentariosService.delete(comentarios);
        return "redirect:/comentarios/listado";
    }

    @GetMapping("/modificar/{idComentarios}")
    public String modificar(Comentarios comentarios, Model model) {
        comentarios = comentariosService.getComentarios(comentarios);
        model.addAttribute("comentarios", comentarios);
        return "/comentarios/modifica";
    }

   // @Autowired
    //private FirebaseStorageService firebaseStorageService;

    //@PostMapping("/guardar")
   // public String guardar(Comentarios comentarios, @RequestParam("imagenFile") MultipartFile imagenFile) {
        //if (!imagenFile.isEmpty()) {//No esta vacio, nos pasan una imagen 
        
           // comentariosService.save(comentarios);
        
      //  String ruta = firebaseStorageService.cargaImagen(imagenFile,
             //   "comentarios",
               // comentarios.getIdComentarios());
       // comentarios.setRutaImagen(ruta);
    }

   // comentariosService.save(comentarios);

//return "redirect:/comentarios/listado";
 //   }

