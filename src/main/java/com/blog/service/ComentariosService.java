
package com.blog.service;


import com.blog.domain.Comentarios;
import com.blog.repository.ComentariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentariosService {

    @Autowired
    private ComentariosRepository comentariosRepository;

    @Transactional(readOnly = true)
    public List<Comentarios> getComentarios(boolean activos) {
        var lista = comentariosRepository.findAll();

        return lista;

    }

    //Se crean los metodos para un CRUD (Create Read Update Delete)
    @Transactional(readOnly = true)
    public Comentarios getComentarios(Comentarios comentarios) {
        comentarios = comentariosRepository.findById(comentarios.getIdComentario()).orElse(null);

        return comentarios;
    }

    @Transactional
    public void delete(Comentarios comentarios) {
        //Elimina el registro que tiene el idComentarios basado en el objeto comentarios 
        comentariosRepository.delete(comentarios);
    }
    
    @Transactional
    public void save (Comentarios comentarios) {
        //Si el idComentarios tiene un valor, se actualiza el registro de ese idComentarios 
        //Si el idComentarios NO tiene un valor, se inserta un registro con la info de la Comentarios 
        comentariosRepository.save(comentarios);
        

   
    }
}
