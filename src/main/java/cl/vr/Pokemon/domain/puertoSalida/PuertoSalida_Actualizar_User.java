package cl.vr.Pokemon.domain.puertoSalida;

import cl.vr.Pokemon.domain.DTO.Request_Update_DTO_Pokemon;
import cl.vr.Pokemon.domain.DTO.Response_DTO_User;

public interface PuertoSalida_Actualizar_User {
    public Response_DTO_User actualizar(Long id, Request_Update_DTO_Pokemon dto);}
