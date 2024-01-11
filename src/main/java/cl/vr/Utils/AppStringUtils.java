package cl.vr.Utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.InternalServerErrorException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@ApplicationScoped
@Slf4j
public class AppStringUtils {

    public Long transformarStringALong(String valor) {
        try{
            return Long.parseLong(valor);
        } catch (Exception e) {
            log.error("Error:"  + e.getMessage());
            throw new InternalServerErrorException("Error al intentar transformar a Long: " + valor);
        }
    }

    public Double transformarStringADouble(String valor) {
        try{
            return Double.parseDouble(valor);
        } catch (Exception e) {
            log.error("Error:"  + e.getMessage());
            throw new InternalServerErrorException("Error al intentar transformar a Double: " + valor);
        }
    }

    public LocalDate transformarStringALocalDate(String valor){
        return LocalDate.parse(valor);
    }
}
