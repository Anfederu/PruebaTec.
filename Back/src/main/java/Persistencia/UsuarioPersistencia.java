/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.UsuarioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author piped
 */
public class UsuarioPersistencia {
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioPersistencia.class.getName());

    @PersistenceContext(unitName = "conexion_mysql")
    protected EntityManager em;

    /**
     * Método para persisitir la entidad en la base de datos.
     *
     * @param UsuarioEntity objeto libro que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public UsuarioEntity create(UsuarioEntity usuarioEntity) {
        LOGGER.log(Level.INFO, "usuario un libro nuevo");
        em.persist(usuarioEntity);
        LOGGER.log(Level.INFO, "usuario creado");
        return usuarioEntity;
    }

    
    public List<UsuarioEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los usuarios");
        Query q = em.createQuery("select u from UsuarioEntity u");
        return q.getResultList();
    }

    
    public UsuarioEntity find(Long UsuarioId) {
        LOGGER.log(Level.INFO, "Consultando el usuario con id={0}", UsuarioId);
        return em.find(UsuarioEntity.class, UsuarioId);
    }

    
    public UsuarioEntity update(UsuarioEntity usuarioEntity) {
        LOGGER.log(Level.INFO, "Actualizando el Usuario con id={0}", usuarioEntity.getId());
        return em.merge(usuarioEntity);
    }

    
    public void delete(Long UsuarioId) {
        LOGGER.log(Level.INFO, "Borrando el usuario con id={0}", UsuarioId);
        UsuarioEntity bookEntity = em.find(UsuarioEntity.class, UsuarioId);
        em.remove(bookEntity);
    }

    
}
