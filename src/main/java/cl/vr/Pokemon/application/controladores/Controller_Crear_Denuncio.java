package cl.vr.Pokemon.application.controladores;

import cl.vr.Denuncio.domain.puertoEntrada.PuertoEntrada_Crear_Denuncio;
import cl.vr.Pokemon.domain.DTO.Request_Save_DTO_User;
import cl.vr.Pokemon.domain.DTO.Response_DTO_User;
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_Crear_Denuncio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_Denuncio implements PuertoEntrada_Crear_Denuncio {

    private PuertoSalida_Crear_Denuncio puertoSalida;

    public Controller_Crear_Denuncio(PuertoSalida_Crear_Denuncio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_User crear(Request_Save_DTO_User dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
