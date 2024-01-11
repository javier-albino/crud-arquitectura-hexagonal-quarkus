package cl.vr.Pokemon.domain.modelo;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import cl.vr.Entrenador.domain.modelo.Entity_Entrenador;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon") // 
public class Entity_Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokemon_id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Column(name = "nombre", nullable = false)
    @Schema(required = true, implementation = String.class, example = "Pikachu")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "tipo")
    @Schema(required = false, implementation = String.class, example = "Eléctrico")
    @JsonbProperty("tipo")
    public String tipo;

    @ManyToOne
    @JoinColumn(name = "entrenador_id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("entrenador_id")
    public Entity_Entrenador entrenador; // Relación con la entidad entrenador

    // Otros métodos y anotaciones según sea necesario
}
