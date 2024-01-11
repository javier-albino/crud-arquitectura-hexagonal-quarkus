package cl.vr.Entrenador.application.controladores;

import cl.vr.Entrenador.domain.DTO.Request_Update_DTO_Entrenador;
import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;
import cl.vr.Entrenador.domain.puertoEntrada.PuertoEntrada_Actualizar_Entrenador;
import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_Actualizar_Entrenador;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_Entrenador implements PuertoEntrada_Actualizar_Entrenador {

    private PuertoSalida_Actualizar_Entrenador puertoSalida;

    public Controller_Actualizar_Entrenador(PuertoSalida_Actualizar_Entrenador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Entrenador actualizar(Long id, Request_Update_DTO_Entrenador dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
