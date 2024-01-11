package cl.vr.Entrenador.domain.puertoSalida;

import cl.vr.Entrenador.domain.DTO.Request_Update_DTO_Entrenador;
import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;


public interface PuertoSalida_Actualizar_Entrenador {
    public Response_DTO_Entrenador actualizar(Long id, Request_Update_DTO_Entrenador dto);}
