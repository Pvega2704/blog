package com.blog.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity
@Table(name = "comentarios")
public class Comentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;    
    private Long postId;  
    private Long userId;   
    private String contenido; 
    private Timestamp createdAt;
    
    
    public Long getIdPost() {
        return postId;
    }

    public void setIdPost(Long postId) {
        this.postId = postId;
    }
    
    public Long getIdUsuario() {
        return userId;
    }

    public void setIdUsuario(Long userId) {
        this.userId = userId;
    }

    public String getContenidoComentario() {
        return contenido;
    }

    public void setContenidoComentario(String contenido) {
        this.contenido = contenido;
    }
  
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
