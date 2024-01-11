package cl.vr.Entrenador.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;
import cl.vr.Entrenador.domain.modelo.Entity_Entrenador;
import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_BuscarTodos_Entrenador;
import cl.vr.Entrenador.utils.Mapper_Entrenador;

import java.util.List;

@ApplicationScoped
@Slf4j
public class BuscarTodos_BD_Entrenador implements PuertoSalida_BuscarTodos_Entrenador {

    private final PanacheRepository_Entrenador repository;

    private final Mapper_Entrenador mapper;

    public BuscarTodos_BD_Entrenador(PanacheRepository_Entrenador repository, Mapper_Entrenador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public List<Response_DTO_Entrenador> buscarTodos() {
        log.info("Buscando todos los Entrenadores...");
        List<Entity_Entrenador> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
