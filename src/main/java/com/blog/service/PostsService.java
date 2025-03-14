
package com.blog.service;


import com.blog.domain.Posts;
import com.blog.repository.PostsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<Posts> getPosts(boolean activos) {
        var lista = postsRepository.findAll();

        return lista;

    }

    //Se crean los metodos para un CRUD (Create Read Update Delete)
    @Transactional(readOnly = true)
    public Posts getPosts(Posts posts) {
        posts = postsRepository.findById(posts.getIdPosts()).orElse(null);

        return posts;
    }

    @Transactional
    public void delete(Posts posts) {
        //Elimina el registro que tiene el idPosts basado en el objeto posts 
        postsRepository.delete(posts);
    }
    
    @Transactional
    public void save (Posts posts) {
        //Si el idPosts tiene un valor, se actualiza el registro de ese idPosts 
        //Si el idPosts NO tiene un valor, se inserta un registro con la info de la Posts 
        postsRepository.save(posts);
        

   
    }
}
