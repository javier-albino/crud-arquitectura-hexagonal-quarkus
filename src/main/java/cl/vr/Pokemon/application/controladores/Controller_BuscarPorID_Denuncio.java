package cl.vr.Pokemon.application.controladores;

import cl.vr.Pokemon.domain.DTO.Response_DTO_User;
import cl.vr.Pokemon.domain.puertoEntrada.PuertoEntrada_BuscarPorID_Denuncio;
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_BuscarPorID_Denuncio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_BuscarPorID_Denuncio implements PuertoEntrada_BuscarPorID_Denuncio {

    private PuertoSalida_BuscarPorID_Denuncio puertoSalida;

    public Controller_BuscarPorID_Denuncio(PuertoSalida_BuscarPorID_Denuncio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_User buscarPorID(Long id) throws Exception {
        return puertoSalida.buscarPorID(id);
    }
}
