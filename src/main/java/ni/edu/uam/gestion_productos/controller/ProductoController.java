package ni.edu.uam.gestion_productos.controller;

import ni.edu.uam.gestion_productos.dto.ProductoRequestDTO;
import ni.edu.uam.gestion_productos.entity.Producto;
import ni.edu.uam.gestion_productos.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> listarPorCategoria(@PathVariable Integer categoriaId) {
        return service.listarPorCategoria(categoriaId);
    }

    @GetMapping("/etiqueta/{etiquetaId}")
    public List<Producto> listarPorEtiqueta(@PathVariable Integer etiquetaId) {
        return service.listarPorEtiqueta(etiquetaId);
    }

    @PostMapping
    public Producto guardar(@RequestBody ProductoRequestDTO dto) {
        return service.guardar(dto);
    }

    @PostMapping("/{productoId}/etiquetas/{etiquetaId}")
    public Producto agregarEtiqueta(@PathVariable Integer productoId, @PathVariable Integer etiquetaId) {
        return service.agregarEtiqueta(productoId, etiquetaId);
    }

    @DeleteMapping("/{productoId}/etiquetas/{etiquetaId}")
    public Producto eliminarEtiqueta(@PathVariable Integer productoId, @PathVariable Integer etiquetaId) {
        return service.eliminarEtiqueta(productoId, etiquetaId);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody ProductoRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
