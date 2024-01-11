package cl.vr.Pokemon.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import cl.vr.Pokemon.domain.DTO.Request_Save_DTO_User;
import cl.vr.Pokemon.domain.DTO.Response_DTO_User;
import cl.vr.Pokemon.domain.modelo.Entity_Pokemon;
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_Crear_Denuncio;
import cl.vr.Pokemon.utils.Mapper_Denuncio;

@ApplicationScoped
@Slf4j
public class Crear_BD_User implements PuertoSalida_Crear_Denuncio {

    private final PanacheRepository_User repository;

    private final Mapper_Denuncio mapper;

    public Crear_BD_User(PanacheRepository_User repository, Mapper_Denuncio mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Override
    public Response_DTO_User crear(Request_Save_DTO_User dto) {
        try {
            //Creamos la nueva entity
            Entity_Pokemon entity = new Entity_Pokemon();
            //Seteamos los valores del Dto a la entity
            entity.setName(dto.getNombre());
            //guardar en BD
            repository.persist(entity);
            //Retornar el DTO
            return mapper.crearDTO(entity);
        }catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al crear Denuncio: " + e.getMessage());
        }

    }
}
