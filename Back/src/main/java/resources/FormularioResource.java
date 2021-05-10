/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;
import Controladores.exceptions.BusinessLogicException;
import Entidades.FormularioEntity;
import Lógica.FormularioLogica;
import Lógica.UsuarioFormularioLogica;
import Lógica.UsuarioLogica;
import dtos.FormularioDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
/**
 *
 * @author piped
 */

@Path("books")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class FormularioResource {
    
    private static final Logger LOGGER = Logger.getLogger(FormularioResource.class.getName());

    @Inject
    private FormularioLogica formularioLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private UsuarioLogica usuarioLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    @Inject
    private UsuarioFormularioLogica usuarioFormularioLogic;
   @POST
    public FormularioDTO createFormulario(FormularioDTO formulario) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "FormularioResource createFormulario: input: {0}", formulario);
        FormularioDTO formularioDTO = new FormularioDTO(formularioLogic.createFormulario(formulario.toEntity()));
        LOGGER.log(Level.INFO, "BookResource createBook: output: {0}", formularioDTO);
        return formularioDTO;
    }

    @GET
    public List<FormularioDTO> getFormularios() {
        LOGGER.info("BookResource getBooks: input: void");
        List<FormularioDTO> listaFormulario = enty2list(formularioLogic.getFormularios());
        LOGGER.log(Level.INFO, "BookResource getBooks: output: {0}", listaFormulario);
        return listaFormulario;
    }
    
     @DELETE
    @Path("{formulariosId: \\d+}")
    public void deleteFormulario(@PathParam("formulariosId") Long formulariosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "FormularioResource deleteFormulario: input: {0}", formulariosId);
        FormularioEntity entity = formularioLogic.getFormulario(formulariosId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + formulariosId + " no existe.", 404);
        }
        formularioLogic.deleteFormulario(formulariosId);
        LOGGER.info("FormularioResource deleteFormulario: output: void");
    }
    
    /**
     *
     * @param entityList
     * @return
     */
    public List<FormularioDTO> enty2list(List<FormularioEntity> entityList) {
        List<FormularioDTO> list = new ArrayList<>();
        for (FormularioEntity entity : entityList) {
            list.add(new FormularioDTO(entity));
        }
        return list;
    }
    
        
}
