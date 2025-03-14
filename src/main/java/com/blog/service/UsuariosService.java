
package com.blog.service;


import com.blog.domain.Usuarios;
import com.blog.repository.UsuariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios(boolean activos) {
        var lista = usuariosRepository.findAll();

        return lista;

    }

    //Se crean los metodos para un CRUD (Create Read Update Delete)
    @Transactional(readOnly = true)
    public Usuarios getUsuarios(Usuarios usuarios) {
        usuarios = usuariosRepository.findById(usuarios.getIdUsuario()).orElse(null);

        return usuarios;
    }

    @Transactional
    public void delete(Usuarios usuarios) {
        //Elimina el registro que tiene el idUsuarios basado en el objeto usuarios 
        usuariosRepository.delete(usuarios);
    }
    
    @Transactional
    public void save (Usuarios usuarios) {
        //Si el idUsuarios tiene un valor, se actualiza el registro de ese idUsuarios 
        //Si el idUsuarios NO tiene un valor, se inserta un registro con la info de la Usuarios 
        usuariosRepository.save(usuarios);
        

   
    }
}
