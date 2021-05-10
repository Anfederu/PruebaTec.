/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;
import Controladores.exceptions.BusinessLogicException;
import Entidades.FormularioEntity;
import Persistencia.FormularioPersistencia;
import Persistencia.UsuarioPersistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author piped
 */
public class FormularioLogica {
    
    private static final Logger LOGGER = Logger.getLogger(FormularioLogica.class.getName());

    @Inject
    private FormularioPersistencia formularioPersistence;
    
    @Inject
    private UsuarioPersistencia persistence;

       
    public FormularioEntity createFormulario(FormularioEntity formularioEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación del Formulario");
        if (formularioEntity.getUsuario() == null || persistence.find(formularioEntity.getUsuario().getId()) == null) {
            throw new BusinessLogicException("La Formulario es inválida");
        }
        formularioPersistence.create(formularioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación del formulario");
        return formularioEntity;
    }

    
    public List<FormularioEntity> getFormularios() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los libros");
        List<FormularioEntity> books = formularioPersistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los libros");
        return books;
    }
    
    public FormularioEntity getFormulario(Long formularioId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el libro con id = {0}", formularioId);
        FormularioEntity bookEntity = formularioPersistence.find(formularioId);
        if (bookEntity == null) {
            LOGGER.log(Level.SEVERE, "El formulario con el id = {0} no existe", formularioId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el libro con id = {0}", formularioId);
        return bookEntity;
    }

    
    /**
     * Eliminar un libro por ID
     *
     * @param booksId El ID del libro a eliminar
     * @throws BusinessLogicException si el libro tiene autores asociados
     */
    public void deleteFormulario(Long formularioId)   {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el formulario con id = {0}", formularioId);
        persistence.delete(formularioId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el formulario con id = {0}", formularioId);
    }
    
    
    
}
