/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import Entidades.UsuarioEntity;

/**
 *
 * @author piped
 */
public class UsuarioDTO {
    
    private Long id;
    
    private String correo;
    
    private String contraseña;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Constructor por defecto
     */
    public UsuarioDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param editorialEntity: Es la entidad que se va a convertir a DTO
     */
    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        if (usuarioEntity != null) {
            this.id = usuarioEntity.getId();
            this.correo = usuarioEntity.getCorreo();
            this.contraseña=usuarioEntity.getContraseña();
        }
    }

    
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public UsuarioEntity toEntity() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(this.id);
        usuarioEntity.setCorreo(this.correo);
        usuarioEntity.setContraseña(this.contraseña);
        return usuarioEntity;
    }

    
}
