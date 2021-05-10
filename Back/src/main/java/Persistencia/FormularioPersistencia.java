/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Entidades.FormularioEntity;
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
public class FormularioPersistencia {
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioPersistencia.class.getName());

    @PersistenceContext(unitName = "conexion_mysql")
    protected EntityManager em;

    /**
     * Método para persisitir la entidad en la base de datos.
     *
     * @param UsuarioEntity objeto libro que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public FormularioEntity create(FormularioEntity usuarioEntity) {
        LOGGER.log(Level.INFO, "usuario un libro nuevo");
        em.persist(usuarioEntity);
        LOGGER.log(Level.INFO, "usuario creado");
        return usuarioEntity;
    }

    
    public List<FormularioEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los formulario");
        Query q = em.createQuery("select u from FormularioEntity u");
        return q.getResultList();
    }

    
    public FormularioEntity find(Long formularioId) {
        LOGGER.log(Level.INFO, "Consultando el formulario con id={0}", formularioId);
        return em.find(FormularioEntity.class, formularioId);
    }

    
    public FormularioEntity update(FormularioEntity usuarioEntity) {
        LOGGER.log(Level.INFO, "Actualizando el formulario con id={0}", usuarioEntity.getId());
        return em.merge(usuarioEntity);
    }

    
    public void delete(Long formularioId) {
        LOGGER.log(Level.INFO, "Borrando el formulario con id={0}", formularioId);
        FormularioEntity bookEntity = em.find(FormularioEntity.class, formularioId);
        em.remove(bookEntity);
    }
    
}
