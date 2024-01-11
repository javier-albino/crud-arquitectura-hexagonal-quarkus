package cl.vr.Pokemon.domain.puertoSalida;

import cl.vr.Pokemon.domain.DTO.Response_DTO_User;

public interface PuertoSalida_BuscarPorID_Denuncio {
    public Response_DTO_User buscarPorID(Long id) throws Exception;

}
