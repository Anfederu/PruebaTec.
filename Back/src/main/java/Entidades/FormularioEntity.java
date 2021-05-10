/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author piped
 */


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class FormularioEntity extends BaseEntity implements Serializable{
    
    public enum MARCA_FAVORITA {
        DELL,
        HP,
        MAC,
        HUAWEI,
        ASUS
    }
    
    public int num_docuemtno;
    
    public String correo;    
     
    public MARCA_FAVORITA marca;
    
    public String comentarios;

        
    public LocalDateTime fecha;
    
   
    @ManyToOne
    private UsuarioEntity usuario;

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public int getNum_docuemtno() {
        return num_docuemtno;
    }

    public void setNum_docuemtno(int num_docuemtno) {
        this.num_docuemtno = num_docuemtno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public MARCA_FAVORITA getMarca() {
        return marca;
    }

    public void setMarca(MARCA_FAVORITA marca) {
        this.marca = marca;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
}
