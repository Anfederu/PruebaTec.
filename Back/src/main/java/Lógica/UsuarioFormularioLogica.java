/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;
import Entidades.FormularioEntity;
import Entidades.UsuarioEntity;
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
public class UsuarioFormularioLogica {
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioFormularioLogica.class.getName());

    @Inject
    private FormularioPersistencia formularioPersistence;
    
    @Inject
    private UsuarioPersistencia usuarioPersistence;

    
    public FormularioEntity addFormulario(Long formulariosId, Long usuarioId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un libro a la editorial con id = {0}", usuarioId);
        UsuarioEntity usuarioEntity = usuarioPersistence.find(usuarioId);
        FormularioEntity formularioEntity = formularioPersistence.find(usuarioId);
        formularioEntity.setUsuario(usuarioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un libro a la editorial con id = {0}", usuarioId);
        return formularioEntity;
    }

    /**
     * Retorna todos los books asociados a una editorial
     *
     * @param editorialsId El ID de la editorial buscada
     * @return La lista de libros de la editorial
     */
    public List<FormularioEntity> getFormularios(Long editorialsId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los libros asociados a la editorial con id = {0}", editorialsId);
        return usuarioPersistence.find(editorialsId).getFormularios();
    }
    
}
