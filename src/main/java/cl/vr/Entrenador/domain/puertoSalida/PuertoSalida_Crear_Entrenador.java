package cl.vr.Entrenador.domain.puertoSalida;

import cl.vr.Entrenador.domain.DTO.Request_Save_DTO_Entrenador;
import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;


public interface PuertoSalida_Crear_Entrenador {
    public Response_DTO_Entrenador crear(Long id, Request_Save_DTO_Entrenador entity);
}
