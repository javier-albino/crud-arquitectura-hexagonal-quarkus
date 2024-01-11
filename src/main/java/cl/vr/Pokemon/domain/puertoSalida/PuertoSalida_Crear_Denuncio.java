package cl.vr.Pokemon.domain.puertoSalida;

import cl.vr.Pokemon.domain.DTO.Request_Save_DTO_User;
import cl.vr.Pokemon.domain.DTO.Response_DTO_User;

public interface PuertoSalida_Crear_Denuncio {
    public Response_DTO_User crear(Request_Save_DTO_User entity);
}
