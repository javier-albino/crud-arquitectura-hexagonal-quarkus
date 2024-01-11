package cl.vr.Utils;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RegisterForReflection
public class ValidationErrorResponse {
    private List<String> errores;
}
