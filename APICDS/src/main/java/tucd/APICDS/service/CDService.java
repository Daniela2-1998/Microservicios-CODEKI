package tucd.APICDS.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tucd.APICDS.configuration.CDConfiguration;
import tucd.APICDS.model.Artista;
import tucd.APICDS.model.CD;
import tucd.APICDS.model.CDDto;
import tucd.APICDS.model.Dolar;
import tucd.APICDS.repository.ArtistaRepository;
import tucd.APICDS.repository.CDRepository;
import tucd.APICDS.util.CDUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CDService {

    @Autowired
    CDRepository cdRepository;

    @Autowired
    CDUtils cdUtils;

    @Autowired
    CDConfiguration cdConfiguration;

    @Autowired
    ArtistaRepository artistaRepository;

    private double getDolar() {
        Dolar dolar = cdConfiguration.fetchDolar();
        return dolar.getPromedio();
    }

    private double getDolarCompra() {
        Dolar dolar = cdConfiguration.fetchDolar();
        return dolar.getCompra();
    }

    public List<Dolar> getAllDolars(){
        return List.of(cdConfiguration.fetchAllDolars());
    }

    // Retornar todos los registros.
    public List<CD> findAllCDS(){
        double dolar = getDolarCompra();
        List<CD> cds = cdRepository.findAll();
        return cds;
        //return cdUtils.cdMapper(cds, dolar);
    }

    // Crear registro.
    public CD createCD(CD cd, Long artistaId){
        Artista artista = artistaRepository.findById(artistaId)
                .orElseThrow(() -> new IllegalArgumentException("No fue posible encontrar al artista"));

        cd.setArtista(artista);
        return cdRepository.save(cd);

    }

    public Optional<CD> buscarCDPorId(Long id){
        return cdRepository.findById(id);
    }

    public void borrarCDPorId(Long id){
        cdRepository.deleteById(id);
    }


    public Optional<CD> actualizarCD(CD cd){
        cdRepository.save(cd);
        return cdRepository.findById(cd.getId());
    }

    public List<CD> getOfertas(Integer precioOferta){
        List<CD> listaCDs = cdRepository.findAll();
        return cdUtils.encontrarOfertas(listaCDs, precioOferta);
    }

    public List<CD> getByGenero(String genero){
        return cdRepository.findByGenero(genero);
    }

    public List<CD> getByLanzamiento(LocalDate lanzamiento){
        return cdRepository.findByLanzamiento(lanzamiento);
    }


}
