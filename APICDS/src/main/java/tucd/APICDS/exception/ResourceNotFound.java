package tucd.APICDS.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFound extends IllegalArgumentException{

    private String nombreRecurso;

    private String nombreCampo;

    private Long valor;

    // Constructor

    public ResourceNotFound(String nombreRecurso, String nombreCampo, Long valor) {
        super(String.format("No se encontró el recurso: " + nombreRecurso +
                " del campo " + nombreCampo + "-" + valor));
        this.nombreRecurso = nombreRecurso;
        this.nombreCampo = nombreCampo;
        this.valor = valor;
    }
}
