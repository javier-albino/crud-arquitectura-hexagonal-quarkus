package cl.vr.Entrenador.infrastructure;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;
import cl.vr.Entrenador.domain.DTO.Request_Update_DTO_Entrenador;
import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;
import cl.vr.Entrenador.domain.modelo.Entity_Entrenador;
import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_Actualizar_Entrenador;
import cl.vr.Entrenador.utils.Mapper_Entrenador;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_Entrenador implements PuertoSalida_Actualizar_Entrenador {

    private final PanacheRepository_Entrenador repository;

    private final Mapper_Entrenador mapper;

    public Actualizar_BD_Entrenador(PanacheRepository_Entrenador repository, Mapper_Entrenador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public Response_DTO_Entrenador actualizar(Long id, Request_Update_DTO_Entrenador dto) {
        try {
            //BUscar en la BD
            Entity_Entrenador entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException("En la tabla Usuario no encontre el ID: " + id));
            //Actualizar la entity con los campos del dto
            entity.setNombre(dto.getNombre());
            //Guardar en BD
            repository.persist(entity);
            //Emitir la respuesta
            return mapper.crearDTO(entity);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al actualizar denuncio: " + e.getMessage());
        }
    }
}
