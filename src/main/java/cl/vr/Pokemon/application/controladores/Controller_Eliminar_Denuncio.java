package cl.vr.Pokemon.application.controladores;

import cl.vr.Pokemon.domain.puertoEntrada.PuertoEntrada_Eliminar_Denuncio;
import cl.vr.Pokemon.domain.puertoSalida.PuertoSalida_Eliminar_Denuncio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Denuncio implements PuertoEntrada_Eliminar_Denuncio {

    private PuertoSalida_Eliminar_Denuncio puertoSalida;

    public Controller_Eliminar_Denuncio(PuertoSalida_Eliminar_Denuncio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
