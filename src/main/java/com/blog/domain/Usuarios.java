package com.blog.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;   
    private String username;    
    private String email;   
    private String password;
    private Timestamp createdAt;
    

    public Long getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNombreUsuario() {
        return username;
    }
    
    public void setNombreUsuario(String username) {
        this.username = username;
    }
    
    public String getCorreoElectronico() {
        return email;
    }
    
    public void setCorreoElectronico(String email) {
        this.email = email;
    }
    
    public String getClave() {
        return password;
    }
    
    public void setClave(String password) {
        this.password = password;
    }

    public Timestamp getFechaCreacion() {
        return createdAt;
    }
    
    public void setFechaCreacion(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
