package ni.edu.uam.gestion_productos.service;

import jakarta.persistence.EntityNotFoundException;
import ni.edu.uam.gestion_productos.dto.ProductoRequestDTO;
import ni.edu.uam.gestion_productos.entity.Categoria;
import ni.edu.uam.gestion_productos.entity.Etiqueta;
import ni.edu.uam.gestion_productos.entity.Producto;
import ni.edu.uam.gestion_productos.repository.CategoriaRepository;
import ni.edu.uam.gestion_productos.repository.EtiquetaRepository;
import ni.edu.uam.gestion_productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final EtiquetaRepository etiquetaRepository;

    public ProductoService(
            ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository,
            EtiquetaRepository etiquetaRepository
    ) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.etiquetaRepository = etiquetaRepository;
    }

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public List<Producto> listarPorCategoria(Integer categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    public List<Producto> listarPorEtiqueta(Integer etiquetaId) {
        return productoRepository.findByEtiquetaId(etiquetaId);
    }

    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Producto con id: " + id + " no encontrado"));
    }

    public Categoria buscarCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Categoria con id: " + id + " no encontrada"));
    }

    public Etiqueta buscarEtiquetaPorId(Integer id) {
        return etiquetaRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Etiqueta con id: " + id + " no encontrada"));
    }

    public Producto guardar(ProductoRequestDTO dto) {
        Categoria categoria = buscarCategoriaPorId(dto.getCategoriaId());

        Producto producto = new Producto();
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    public Producto agregarEtiqueta(Integer productoId, Integer etiquetaId) {
        Producto producto = buscarPorId(productoId);
        Etiqueta etiqueta = buscarEtiquetaPorId(etiquetaId);

        producto.getEtiquetas().add(etiqueta);

        return productoRepository.save(producto);
    }

    public Producto eliminarEtiqueta(Integer productoId, Integer etiquetaId) {
        Producto producto = buscarPorId(productoId);
        Etiqueta etiqueta = buscarEtiquetaPorId(etiquetaId);

        producto.getEtiquetas().remove(etiqueta);

        return productoRepository.save(producto);
    }

    public Producto actualizar(Integer id, ProductoRequestDTO dto) {
        Producto producto = buscarPorId(id);

        Categoria categoria = buscarCategoriaPorId(dto.getCategoriaId());

        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}
