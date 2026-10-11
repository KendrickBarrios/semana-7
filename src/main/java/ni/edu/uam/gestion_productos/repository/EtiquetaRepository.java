package ni.edu.uam.gestion_productos.repository;

import ni.edu.uam.gestion_productos.entity.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
}
