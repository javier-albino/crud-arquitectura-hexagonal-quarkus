package cl.vr.Entrenador.application.controladores;

import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;
import cl.vr.Entrenador.domain.puertoEntrada.PuertoEntrada_BuscarPorID_Entrenador;
import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_BuscarPorID_Entrenador;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class Controller_BuscarPorID_Entrenador implements PuertoEntrada_BuscarPorID_Entrenador {

    private PuertoSalida_BuscarPorID_Entrenador puertoSalida;

    public Controller_BuscarPorID_Entrenador(PuertoSalida_BuscarPorID_Entrenador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Entrenador buscarPorID(Long id) throws Exception {
        return puertoSalida.buscarPorID(id);
    }
}
