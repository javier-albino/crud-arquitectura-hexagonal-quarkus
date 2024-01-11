package cl.vr.Pokemon.domain.DTO;

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
public class Request_Update_DTO_Pokemon {

    @NotNull(message = "El campo nombre es requerido")
    @Size(min = 3, max = 10, message = "El nombre debe poseer entre 3 y 10 caracteres")
    @Schema(required = true, implementation = String.class, example = "user1235")
    @JsonbProperty("nombre")
    public String nombre;


}
