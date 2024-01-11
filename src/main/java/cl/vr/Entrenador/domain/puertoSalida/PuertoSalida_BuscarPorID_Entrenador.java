package cl.vr.Entrenador.domain.puertoSalida;

import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;


public interface PuertoSalida_BuscarPorID_Entrenador {
    public Response_DTO_Entrenador buscarPorID(Long id) throws Exception;

}
