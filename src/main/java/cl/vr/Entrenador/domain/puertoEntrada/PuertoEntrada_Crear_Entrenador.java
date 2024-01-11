package cl.vr.Entrenador.domain.puertoEntrada;

import cl.vr.Entrenador.domain.DTO.Request_Save_DTO_Entrenador;

import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;


public interface PuertoEntrada_Crear_Entrenador {
    public Response_DTO_Entrenador crear(Long id, Request_Save_DTO_Entrenador dtoIn);
}
