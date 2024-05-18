package tucd.APICDS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tucd.APICDS.model.CD;
import tucd.APICDS.model.Dolar;
import tucd.APICDS.service.CDService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cds")
public class CDController {

    @Autowired
    CDService cdService;

    @CrossOrigin
    @GetMapping("")
    public List<CD> getAllCDS(){
        return cdService.findAllCDS();
    }

    @GetMapping("/{id}")
    public Optional<CD> findCDById(@PathVariable Long id){
        return cdService.buscarCDPorId(id);
    }

    @PostMapping("/agregar")
    public void createCD (@RequestBody CD cd, @RequestParam Long artistaId){
        cdService.createCD(cd, artistaId);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteCD(@PathVariable Long id){
        cdService.borrarCDPorId(id);
    }

    @PutMapping("/actualizar")
    public Optional<CD> updateCD(@RequestBody CD cd){
        return cdService.actualizarCD(cd);
    }

    @GetMapping("/ofertas")
    public List<CD> getOfertas(@RequestParam (name ="precio") int precioOferta){
        return cdService.getOfertas(precioOferta);
    }

    @GetMapping("/genero")
    public List<CD> getByGenero(@RequestParam String genero){
        return cdService.getByGenero(genero);
    }

    @GetMapping("/lanzamiento")
    public List<CD> getByLanzamiento(@RequestParam LocalDate lanzamiento){
        return cdService.getByLanzamiento(lanzamiento);
    }



    @GetMapping("/allDolars")
    public List<Dolar> getAllDolars(){
        return cdService.getAllDolars();
    }
}
