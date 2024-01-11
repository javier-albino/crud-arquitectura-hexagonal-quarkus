package cl.vr.Utils;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
@RegisterForReflection
public class GeneralStringResponse {

    private String mensaje;
}
