package cl.vr.Entrenador.domain.puertoEntrada;

import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;


public interface PuertoEntrada_BuscarPorID_Entrenador {
    public Response_DTO_Entrenador buscarPorID(Long id) throws Exception;
}
