
package com.blog.service;


import com.blog.domain.Categoria;
import com.blog.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<Categoria> getCategoria(boolean activos) {
        var lista = categoriaRepository.findAll();

        return lista;

    }

    //Se crean los metodos para un CRUD (Create Read Update Delete)
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        categoria = categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);

        return categoria;
    }

    @Transactional
    public void delete(Categoria categoria) {
        //Elimina el registro que tiene el idCategoria basado en el objeto categoria 
        categoriaRepository.delete(categoria);
    }
    
    @Transactional
    public void save (Categoria categoria) {
        //Si el idCategoria tiene un valor, se actualiza el registro de ese idCategoria 
        //Si el idCategoria NO tiene un valor, se inserta un registro con la info de la Categoria 
        categoriaRepository.save(categoria);
        

   
    }
}
