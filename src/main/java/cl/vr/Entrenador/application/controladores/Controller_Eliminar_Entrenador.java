package cl.vr.Entrenador.application.controladores;

import cl.vr.Entrenador.domain.puertoSalida.PuertoSalida_Eliminar_Entrenador;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Entrenador implements PuertoSalida_Eliminar_Entrenador {

    private PuertoSalida_Eliminar_Entrenador puertoSalida;

    public Controller_Eliminar_Entrenador(PuertoSalida_Eliminar_Entrenador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
