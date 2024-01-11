package cl.vr.Pokemon.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import cl.vr.Pokemon.domain.DTO.Request_Update_DTO_Pokemon;
import cl.vr.Pokemon.domain.DTO.Response_DTO_User;
import cl.vr.Pokemon.domain.modelo.Entity_Pokemon;
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_Actualizar_User;
import cl.vr.Pokemon.utils.Mapper_Denuncio;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_User implements PuertoSalida_Actualizar_User {

    private final PanacheRepository_User repository;

    private final Mapper_Denuncio mapper;

    public Actualizar_BD_User(PanacheRepository_User repository, Mapper_Denuncio mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public Response_DTO_User actualizar(Long id, Request_Update_DTO_Pokemon dto) {
        try {
            //BUscar en la BD
            Entity_Pokemon entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException("En la tabla Usuario no encontre el ID: " + id));
            //Actualizar la entity con los campos del dto
            entity.setName(dto.getNombre());
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
