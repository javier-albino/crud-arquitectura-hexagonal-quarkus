package cl.vr.Pokemon.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.vr.Utils.Constants.*;

import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_Eliminar_Denuncio;

@ApplicationScoped
@Slf4j
public class Eliminar_BD_User implements PuertoSalida_Eliminar_Denuncio {

    private final PanacheRepository_User repository;

    public Eliminar_BD_User(PanacheRepository_User repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void eliminarPorID(Long id) {
        try {
            log.info("[DELETE] eliminando por id " + id);
            //buscamos si exite en BD
            repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(EN_TABLA + "DENUNCIO" + NO_ENCONTRADO + id));
            //borramos de la BD
            repository.deleteById(id);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
