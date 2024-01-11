package cl.vr.Utils;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RegisterForReflection
@JsonbPropertyOrder(value =  {"data","cantidadElementosEncontrados","cantidadDePaginas","tieneSiguientePagina","tienePaginaAnterior" })
public class PaginadoResponse {

    private Object data;
    private Long cantidadElementosEncontrados;
    private int cantidadDePaginas;
    private boolean tieneSiguientePagina;
    private boolean tienePaginaAnterior;
}
