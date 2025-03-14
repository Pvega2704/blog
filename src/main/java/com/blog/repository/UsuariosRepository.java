
package com.blog.repository;

import com.blog.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuariosRepository  extends JpaRepository <Usuarios,Long>{
    
}
