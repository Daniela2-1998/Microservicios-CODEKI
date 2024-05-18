package tucd.APICDS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tucd.APICDS.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
