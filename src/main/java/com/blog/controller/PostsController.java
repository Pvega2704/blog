package com.blog.controller;

import com.blog.domain.Posts;
import com.blog.service.PostsService;
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
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = postsService.getPosts(false);
        model.addAttribute("posts", lista);
        model.addAttribute("totalPosts", lista.size());
        return "/posts/listado";
    }

    @GetMapping("/eliminar/{idPosts}")
    public String eliminar(Posts posts) {
        postsService.delete(posts);
        return "redirect:/posts/listado";
    }

    @GetMapping("/modificar/{idPosts}")
    public String modificar(Posts posts, Model model) {
        posts = postsService.getPosts(posts);
        model.addAttribute("posts", posts);
        return "/posts/modifica";
    }

   // @Autowired
    //private FirebaseStorageService firebaseStorageService;

    //@PostMapping("/guardar")
   // public String guardar(Posts posts, @RequestParam("imagenFile") MultipartFile imagenFile) {
        //if (!imagenFile.isEmpty()) {//No esta vacio, nos pasan una imagen 
        
           // postsService.save(posts);
        
      //  String ruta = firebaseStorageService.cargaImagen(imagenFile,
             //   "posts",
               // posts.getIdPosts());
       // posts.setRutaImagen(ruta);
    }

   // postsService.save(posts);

//return "redirect:/posts/listado";
 //   }

