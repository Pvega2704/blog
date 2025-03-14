package com.blog.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "posts")
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosts;
    private Long userId;
    private String titulo;
    private String contenido;
    private String imageUrl; 
    private Timestamp createdAt; 
    private Timestamp updatedAt;
    
 

    public Long getIdUsuario() {
        return userId;
    }

    public void setIdUsuario(Long userId) {
        this.userId = userId;
    }
    
    public String getTituloPost() {
        return titulo;
    }

    public void setTituloPost(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescripcion() {
        return contenido;
    }

    public void setDescripcion(String contenido) {
        this.contenido = contenido;
    }
    
    public String getImagenUrl() {
        return imageUrl;
    }

    public void setImagenUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
