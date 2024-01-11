package cl.vr.Entrenador.utils;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

import cl.vr.Entrenador.domain.DTO.Response_DTO_Entrenador;
import cl.vr.Entrenador.domain.modelo.Entity_Entrenador;

@ApplicationScoped
public class Mapper_Entrenador {


    public Response_DTO_Entrenador crearDTO(Entity_Entrenador entity) {
        Response_DTO_Entrenador dto = new Response_DTO_Entrenador();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public List<Response_DTO_Entrenador> crearDTO(List<Entity_Entrenador> entities) {
        List<Response_DTO_Entrenador> dtos = new ArrayList<>();
        for (Entity_Entrenador entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

}

