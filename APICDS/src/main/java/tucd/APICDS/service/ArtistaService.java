package tucd.APICDS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tucd.APICDS.exception.ResourceNotFound;
import tucd.APICDS.model.Artista;
import tucd.APICDS.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    @Autowired
    ArtistaRepository artistaRepository;

    public List<Artista> getAllArtistas(){
        return artistaRepository.findAll();
    }

    public void addArtista(Artista artista){
        artistaRepository.save(artista);
    }

    public Artista getArtistaById(Long id) throws ResourceNotFound{
        return artistaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Artista", "id", id));
    }

    public void deleteArtista(Long id) throws ResourceNotFound{
        Artista artista = artistaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Artista", "id", id));
        artistaRepository.deleteById(id);
    }

    public Optional<Artista> updateArtista(Artista artista){
        artistaRepository.save(artista);
        return artistaRepository.findById(artista.getId());
    }

}
