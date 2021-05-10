/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;
import Controladores.exceptions.BusinessLogicException;
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
public class UsuarioLogica {
    
     private static final Logger LOGGER = Logger.getLogger(UsuarioLogica.class.getName());

    @Inject
    private UsuarioPersistencia persistence;

    @Inject
    private FormularioPersistencia editorialPersistence;

    /**
     * Guardar un nuevo libro
     *
     * @param bookEntity La entidad de tipo libro del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el ISBN es inválido o ya existe en la
     * persistencia.
     */
    public UsuarioEntity createUsuario(UsuarioEntity usuarioEntity)  {
        LOGGER.log(Level.INFO, "Inicia proceso de creación del usuario");        
        persistence.create(usuarioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación del usuario");
        return usuarioEntity;
    }
    
    
}
