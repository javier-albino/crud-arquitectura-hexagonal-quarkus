package cl.vr.Pokemon.application.rutas;


import cl.vr.Pokemon.application.controladores.*;
import cl.vr.Pokemon.domain.DTO.Request_Save_DTO_User;
import cl.vr.Pokemon.domain.DTO.Request_Update_DTO_User;
import cl.vr.Pokemon.domain.puertoSalida.*;
import cl.vr.Utils.GeneralErrorResponse;
import cl.vr.Utils.GeneralStringResponse;
import cl.vr.Utils.ValidationErrorResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static cl.vr.Utils.Constants.INTERNAL_SERVER_ERROR;
import static cl.vr.Utils.Constants.REGISTRO_ELIMINADO;

@Path("/v1/syssinvidacol/col/user")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
@Slf4j
public class Rutas_User {

    @Inject
    Validator validator;

    @Inject
    PuertoSalida_BuscarTodos_Denuncio buscarTodos_PuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_Denuncio buscarPorID_PuertoSalida;
    @Inject
    PuertoSalida_Crear_Denuncio crear_PuertoSalida;
    @Inject
    PuertoSalida_Actualizar_User actualizar_PuertoSalida;
    @Inject
    PuertoSalida_Eliminar_Denuncio eliminar_PuertoSalida;

    @GET
    @APIResponses(
            value = {@APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodos")
    public Response getAll() {
        log.info("[GET] - Buscar todos los denuncios");
        Controller_BuscarTodos_Denuncio controlador = new Controller_BuscarTodos_Denuncio(buscarTodos_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.buscarTodos()).build();
    }

    public Response fallbackTodos() {
        return Response.status(503).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Fallback(fallbackMethod = "fallbackGetById")
    public Response getById(@PathParam("id") Long id) throws Exception {
        try {
            log.info("[GET] - Buscar el Denuncio: " + id);
            Controller_BuscarPorID_Denuncio controlador = new Controller_BuscarPorID_Denuncio(buscarPorID_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.buscarPorID(id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackGetById(Long id) {
        return Response.status(503).build();
    }

    @POST
    @Retry(maxRetries = 3, delay = 3000, abortOn = {ValidationException.class})
    @Fallback(fallbackMethod = "fallbackCrear")
    public Response crear(Request_Save_DTO_User dto) {
        try {
            Set<ConstraintViolation<Request_Save_DTO_User>> violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                List<String> error = new ArrayList<>();
                violations.forEach(x -> error.add(x.getMessage()));
                return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(error)).build();
            }
            Controller_Crear_Denuncio controlador = new Controller_Crear_Denuncio(crear_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.crear(dto)).build();
        } catch (BadRequestException | NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (InternalServerErrorException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new GeneralErrorResponse(INTERNAL_SERVER_ERROR)).build();
        }
    }

    public Response fallbackCrear(Request_Save_DTO_User dto) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackActualizar")
    public Response actualizar(@PathParam("id") Long id, Request_Update_DTO_User dto) {
        try {
            Set<ConstraintViolation<Request_Update_DTO_User>> violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                List<String> errors = new ArrayList<>();
                violations.forEach(x -> errors.add(x.getMessage()));
                return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(errors)).build();
            }
            Controller_Actualizar_User controlador = new Controller_Actualizar_User(actualizar_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.actualizar(id, dto)).build();
        } catch (BadRequestException | NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (InternalServerErrorException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new GeneralErrorResponse(INTERNAL_SERVER_ERROR)).build();
        }
    }

    public Response fallbackActualizar(Long id, Request_Update_DTO_User dto) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackEliminar")
    public Response eliminar(@PathParam("id") Long id) {
        try {
            Controller_Eliminar_Denuncio controlador = new Controller_Eliminar_Denuncio(eliminar_PuertoSalida);
            controlador.eliminarPorID(id);
            return Response.status(Response.Status.OK).entity(new GeneralStringResponse(REGISTRO_ELIMINADO + id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackEliminar(Long id) {
        return Response.status(503).build();
    }
}
