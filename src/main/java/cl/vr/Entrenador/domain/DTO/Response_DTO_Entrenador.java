package cl.vr.Entrenador.domain.DTO;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
@JsonbPropertyOrder(value = {
        "id",
        "nombre",
        "nivel",
        "edad"
})
public class Response_DTO_Entrenador {

    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Schema(required = true, implementation = String.class, example = "Ash Ketchum")
    @JsonbProperty("nombre")
    public String nombre;

    @Schema(required = true, implementation = Integer.class, example = "10")
    @JsonbProperty("nivel")
    public Integer nivel;

    @Schema(required = true, implementation = Integer.class, example = "30")
    @JsonbProperty("edad")
    public Integer edad;

   
}