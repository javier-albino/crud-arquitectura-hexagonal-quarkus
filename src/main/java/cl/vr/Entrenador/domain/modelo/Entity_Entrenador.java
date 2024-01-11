package cl.vr.Entrenador.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrenador")
public class Entity_Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrenador_id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    @Schema(required = true, implementation = String.class, example = "Ash Ketchum")
    @JsonbProperty("nombre")
    private String nombre;

    @Column(name = "nivel")
    @Schema(required = false, implementation = Integer.class, example = "10")
    @JsonbProperty("nivel")
    private Integer nivel;

    @Column(name = "edad", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "30")
    @JsonbProperty("edad")
    private Integer edad;

  

    // Otros métodos y anotaciones según sea necesario
}
