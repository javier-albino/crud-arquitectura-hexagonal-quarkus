package cl.vr.Pokemon.domain.puertoEntrada;

import cl.vr.Pokemon.domain.DTO.Response_DTO_User;

public interface PuertoEntrada_BuscarPorID_Pokemon {
    public Response_DTO_User buscarPorID(Long id) throws Exception;
}
