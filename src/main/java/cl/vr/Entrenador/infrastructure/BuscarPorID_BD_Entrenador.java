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
import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_BuscarPorID_Entrenador;
import cl.vr.Entrenador.utils.Mapper_Entrenador;

import static cl.vr.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_Entrenador implements PuertoSalida_BuscarPorID_Entrenador {


    private final PanacheRepository_Entrenador repository;

    private final Mapper_Entrenador mapper;

    public BuscarPorID_BD_Entrenador(PanacheRepository_Entrenador repository, Mapper_Entrenador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public Response_DTO_Entrenador buscarPorID(Long id) throws Exception {
        try {
            log.info("Buscando el entrenador: " + id);
            //Ir a la BD a buscar
            Entity_Entrenador entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(EN_TABLA + "DENUNCIO" + NO_ENCONTRADO + id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
