
package com.blog.repository;

import com.blog.domain.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComentariosRepository  extends JpaRepository <Comentarios,Long>{
    
}
