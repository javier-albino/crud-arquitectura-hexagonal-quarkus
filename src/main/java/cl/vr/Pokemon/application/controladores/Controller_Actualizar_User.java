package cl.vr.Pokemon.application.controladores;

import cl.vr.Pokemon.domain.DTO.Request_Update_DTO_User;
import cl.vr.Pokemon.domain.DTO.Response_DTO_User;
import cl.vr.Pokemon.domain.puertoEntrada.PuertoEntrada_Actualizar_User;
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_Actualizar_User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_User implements PuertoEntrada_Actualizar_User {

    private PuertoSalida_Actualizar_User puertoSalida;

    public Controller_Actualizar_User(PuertoSalida_Actualizar_User puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_User actualizar(Long id, Request_Update_DTO_User dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
