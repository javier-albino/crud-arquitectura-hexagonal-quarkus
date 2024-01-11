package cl.vr.Entrenador.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.vr.Utils.Constants.*;

import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_Eliminar_Entrenador;

@ApplicationScoped
@Slf4j
public class Eliminar_BD_Entrenador implements PuertoSalida_Eliminar_Entrenador {

    private final PanacheRepository_Entrenador repository;

    public Eliminar_BD_Entrenador(PanacheRepository_Entrenador repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void eliminarPorID(Long id) {
        try {
            log.info("[DELETE] eliminando por id " + id);
            //buscamos si exite en BD
            repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(EN_TABLA + "Entrenador" + NO_ENCONTRADO + id));
            //borramos de la BD
            repository.deleteById(id);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
