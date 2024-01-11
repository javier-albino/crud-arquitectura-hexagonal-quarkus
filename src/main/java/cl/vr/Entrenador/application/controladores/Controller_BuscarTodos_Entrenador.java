package cl.vr.Entrenador.application.controladores;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;
import cl.vr.Entrenador.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Entrenador;
import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_BuscarTodos_Entrenador;

@ApplicationScoped
public class Controller_BuscarTodos_Entrenador implements PuertoEntrada_BuscarTodos_Entrenador {

    private PuertoSalida_BuscarTodos_Entrenador puertoSalida;

    public Controller_BuscarTodos_Entrenador(PuertoSalida_BuscarTodos_Entrenador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_Entrenador> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
