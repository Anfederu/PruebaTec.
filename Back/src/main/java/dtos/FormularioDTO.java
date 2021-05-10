/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import Entidades.FormularioEntity;
import Entidades.UsuarioEntity;
import java.time.LocalDateTime;

/**
 *
 * @author piped
 */
public class FormularioDTO {
    
    private Long id;
     
    public int num_documento;
    
    public String correo;    
     
    public FormularioEntity.MARCA_FAVORITA marca;
    
    public String comentarios;
    
    public LocalDateTime fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum_docuemtno() {
        return num_documento;
    }

    public void setNum_docuemtno(int num_docuemtno) {
        this.num_documento = num_docuemtno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public FormularioEntity.MARCA_FAVORITA getMarca() {
        return marca;
    }

    public void setMarca(FormularioEntity.MARCA_FAVORITA marca) {
        this.marca = marca;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public UsuarioDTO getUusario() {
        return usuario;
    }

    public void setEditorial(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    /*
    * Relación a una editorial  
    * dado que esta tiene cardinalidad 1.
     */
    private UsuarioDTO usuario;

    /**
     * Constructor por defecto
     */
    public FormularioDTO() {
    }

    /**
     * Constructor a partir de la entidad
     *
     * @param bookEntity La entidad del libro
     */
    public FormularioDTO(FormularioEntity formularioEntity) {
        if (formularioEntity != null) {
            this.id = formularioEntity.getId();
            this.num_documento = formularioEntity.getNum_docuemtno();
            this.comentarios = formularioEntity.getComentarios();
            this.correo = formularioEntity.getCorreo();
            this.fecha = formularioEntity.getFecha();
            this.marca = formularioEntity.getMarca();
            if (formularioEntity.getUsuario() != null) {
                this.usuario = new UsuarioDTO(formularioEntity.getUsuario());
            } else {
                this.usuario = null;
            }
        }
    }

    /**
     * Método para transformar el DTO a una entidad.
     *
     * @return La entidad del libro asociado.
     */
    public FormularioEntity toEntity() {
        FormularioEntity formularioEntity = new FormularioEntity();
        formularioEntity.setId(this.id);
        formularioEntity.setNum_docuemtno(this.num_documento);
        formularioEntity.setCorreo(this.correo);
        formularioEntity.setComentarios(this.comentarios);
        formularioEntity.setFecha(this.fecha);
        formularioEntity.setMarca(this.marca);
                if (this.usuario != null) {
            formularioEntity.setUsuario(this.usuario.toEntity());
        }
        return formularioEntity;
    }

    
    
}
