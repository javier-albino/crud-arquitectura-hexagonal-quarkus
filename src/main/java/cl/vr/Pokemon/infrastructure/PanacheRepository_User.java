package cl.vr.Pokemon.infrastructure;

import cl.vr.Pokemon.domain.modelo.Entity_Pokemon;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_User implements PanacheRepository<Entity_Pokemon> {

}
