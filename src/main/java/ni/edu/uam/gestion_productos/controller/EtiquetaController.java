package ni.edu.uam.gestion_productos.controller;

import ni.edu.uam.gestion_productos.entity.Etiqueta;
import ni.edu.uam.gestion_productos.service.EtiquetaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
public class EtiquetaController {

    private final EtiquetaService service;

    public EtiquetaController(EtiquetaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Etiqueta> listar() {
        return service.listar();
    }

    @PostMapping
    public Etiqueta guardar(@RequestBody Etiqueta etiqueta) {
        return service.guardar(etiqueta);
    }
}
