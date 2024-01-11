package cl.vr.Entrenador.application.controladores;

import cl.vr.Entrenador.domain.DTO.Request_Save_DTO_Entrenador;
import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;
import cl.vr.Entrenador.domain.puertoEntrada.PuertoEntrada_Crear_Entrenador;
import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_Crear_Entrenador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Controller_Crear_Entrenador implements PuertoEntrada_Crear_Entrenador {

    private final PuertoSalida_Crear_Entrenador puertoSalida;

    @Inject
    public Controller_Crear_Entrenador(PuertoSalida_Crear_Entrenador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Entrenador crear(Long id ,Request_Save_DTO_Entrenador dtoIn) {
        // Implementación de la lógica para guardar un entrenador
        return puertoSalida.crear(dtoIn);
    }
}
