package cl.vr.Pokemon.utils;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

import cl.vr.Pokemon.domain.DTO.Response_DTO_User;
import cl.vr.Pokemon.domain.modelo.Entity_Pokemon;

@ApplicationScoped
public class Mapper_Denuncio {


    public Response_DTO_User crearDTO(Entity_Pokemon entity) {
        Response_DTO_User dto = new Response_DTO_User();
        dto.setId(entity.getId());
        dto.setNombre(entity.getName());
        dto.setSaludo("Hola Mundo");
        return dto;
    }

    public List<Response_DTO_User> crearDTO(List<Entity_Pokemon> entities) {
        List<Response_DTO_User> dtos = new ArrayList<>();
        for (Entity_Pokemon entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

}

