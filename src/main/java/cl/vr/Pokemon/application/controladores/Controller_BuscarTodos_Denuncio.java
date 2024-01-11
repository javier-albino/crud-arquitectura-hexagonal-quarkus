package cl.vr.Pokemon.application.controladores;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

import cl.vr.Pokemon.domain.DTO.Response_DTO_User;
import cl.vr.Pokemon.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Denuncio;
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_BuscarTodos_Denuncio;

@ApplicationScoped
public class Controller_BuscarTodos_Denuncio implements PuertoEntrada_BuscarTodos_Denuncio {

    private PuertoSalida_BuscarTodos_Denuncio puertoSalida;

    public Controller_BuscarTodos_Denuncio(PuertoSalida_BuscarTodos_Denuncio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_User> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
