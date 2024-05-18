package tucd.APICDS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tucd.APICDS.exception.ResourceNotFound;
import tucd.APICDS.model.Artista;
import tucd.APICDS.service.ArtistaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

    @Autowired
    ArtistaService artistaService;

    @GetMapping("")
    public List<Artista> getAllArtistas(){
        return artistaService.getAllArtistas();
    }

    @GetMapping("/{id}")
    public String getArtistaById(@PathVariable Long id){
        try {
            return String.valueOf(artistaService.getArtistaById(id));
        } catch (ResourceNotFound e){
            System.out.println(e.getMessage());
            return "No se encontró al artista";
        }
    }

    @PostMapping("/addartista")
    public void addArtista(@RequestBody Artista artista){
       artistaService.addArtista(artista);
    }

    @DeleteMapping("/deleteartista/{id}")
    public String deleteArtista(@PathVariable Long id){
        try{
            artistaService.deleteArtista(id);
            return "Artista eliminado éxitosamente";
        } catch (ResourceNotFound e){
           System.out.println(e.getMessage());
           return "No se encontró al artista";
        }
    }

    @PutMapping("/updateartista")
    public Optional<Artista> updateArtista(@RequestBody Artista artista){
        return artistaService.updateArtista(artista);
    }

}
