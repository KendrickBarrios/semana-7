package ni.edu.uam.gestion_productos.repository;

import ni.edu.uam.gestion_productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCategoriaId(Integer categoriaId);
    @Query("""
        SELECT DISTINCT p
        FROM Producto p
        JOIN p.etiquetas t
        WHERE t.id = :etiquetaId
    """)
    List<Producto> findByEtiquetaId(@Param("etiquetaId") Integer etiquetaId);
}
