package cl.vr.Entrenador.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import cl.vr.Entrenador.domain.DTO.Request_Save_DTO_Entrenador;
import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;
import cl.vr.Entrenador.domain.modelo.Entity_Entrenador;
import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_Crear_Entrenador;
import cl.vr.Entrenador.utils.Mapper_Entrenador;

@ApplicationScoped
@Slf4j
public class Crear_BD_Entrenador implements PuertoSalida_Crear_Entrenador {

    private final PanacheRepository_Entrenador repository;

    private final Mapper_Entrenador mapper;

    public Crear_BD_Entrenador(PanacheRepository_Entrenador repository, Mapper_Entrenador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Override
    public Response_DTO_Entrenador crear(Request_Save_DTO_Entrenador dto) {
        try {
            //Creamos la nueva entity
            Entity_Entrenador entity = new Entity_Entrenador();
            //Seteamos los valores del Dto a la entity
            entity.setNombre(dto.getNombre());
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
