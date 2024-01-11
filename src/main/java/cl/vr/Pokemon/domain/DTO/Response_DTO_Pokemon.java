package cl.vr.Pokemon.domain.DTO;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
@JsonbPropertyOrder({"id", "nombre", "tipo", "entrenador"})
public class Response_DTO_Pokemon {

    @Schema(required = true, implementation = Long.class, example = "25")
    @JsonbProperty("id")
    public Long id;

    @Schema(required = true, implementation = String.class, example = "Pikachu")
    @JsonbProperty("nombre")
    public String nombre;

    @Schema(required = true, implementation = String.class, example = "Eléctrico")
    @JsonbProperty("tipo")
    public String tipo;

    @Schema(implementation = Response_DTO_Entrenador.class)
    @JsonbProperty("entrenador")
    public Response_DTO_Entrenador entrenador; // Información del Entrenador asociado

    // Otros campos relevantes de Pokémon
}
