package cl.vr.Pokemon.domain.puertoEntrada;

import cl.vr.Pokemon.domain.DTO.Request_Update_DTO_Pokemon;
import cl.vr.Pokemon.domain.DTO.Response_DTO_Pokemon;


public interface PuertoEntrada_Actualizar_Pokemon {
    public Response_DTO_Pokemon actualizar(Long id, Request_Update_DTO_Pokemon dtoIn);
}
