package tucd.APICDS.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CDDto {

    private Long id;

    private String nombre;

    private LocalDate lanzamiento;

    private int duracion;

    private String genero;

    private double precio;



    // Constructor
    public CDDto(Long id, String nombre, LocalDate lanzamiento, int duracion, String genero, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
        this.duracion = duracion;
        this.genero = genero;
        this.precio = precio;
    }
}
