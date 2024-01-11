package cl.vr.Pokemon.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import cl.vr.Pokemon.domain.DTO.Response_DTO_User;
import cl.vr.Pokemon.domain.modelo.Entity_Pokemon;
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_BuscarTodos_Denuncio;
import cl.vr.Pokemon.utils.Mapper_Denuncio;

import java.util.List;

@ApplicationScoped
@Slf4j
public class BuscarTodos_BD_User implements PuertoSalida_BuscarTodos_Denuncio {

    private final PanacheRepository_User repository;

    private final Mapper_Denuncio mapper;

    public BuscarTodos_BD_User(PanacheRepository_User repository, Mapper_Denuncio mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public List<Response_DTO_User> buscarTodos() {
        log.info("Buscando todos los denuncios...");
        List<Entity_Pokemon> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
