package cl.vr.Entrenador.infrastructure;

import cl.vr.Entrenador.domain.modelo.Entity_Entrenador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_Entrenador implements PanacheRepository<Entity_Entrenador> {

}
