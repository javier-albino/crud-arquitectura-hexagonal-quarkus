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
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_BuscarPorID_Denuncio;
import cl.vr.Pokemon.utils.Mapper_Denuncio;

import static cl.vr.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_User implements PuertoSalida_BuscarPorID_Denuncio {


    private final PanacheRepository_User repository;

    private final Mapper_Denuncio mapper;

    public BuscarPorID_BD_User(PanacheRepository_User repository, Mapper_Denuncio mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public Response_DTO_User buscarPorID(Long id) throws Exception {
        try {
            log.info("Buscando el denuncio: " + id);
            //Ir a la BD a buscar
            Entity_Pokemon entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(EN_TABLA + "DENUNCIO" + NO_ENCONTRADO + id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
