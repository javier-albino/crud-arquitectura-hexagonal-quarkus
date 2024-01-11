package cl.vr.Entrenador.domain.DTO;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
public class Request_Save_DTO_Entrenador {

    @NotNull(message = "El campo nombre es requerido")
    @Size(min = 3, max = 10, message = "El nombre debe poseer entre 3 y 10 caracteres")
    @Schema(required = true, implementation = String.class, example = "Ash Ketchum")
    @JsonbProperty("nombre")
    public String nombre;

    @NotNull(message = "El campo nivel es requerido")
    @Schema(required = true, implementation = Integer.class, example = "10")
    @JsonbProperty("nivel")
    public Integer nivel;

    @NotNull(message = "El campo edad es requerido")
    @Schema(required = true, implementation = Integer.class, example = "30")
    @JsonbProperty("edad")
    public Integer edad;

}