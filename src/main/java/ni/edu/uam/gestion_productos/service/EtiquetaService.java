package ni.edu.uam.gestion_productos.service;

import ni.edu.uam.gestion_productos.entity.Etiqueta;
import ni.edu.uam.gestion_productos.repository.EtiquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {

    private final EtiquetaRepository repository;

    public EtiquetaService(EtiquetaRepository repository) {
        this.repository = repository;
    }

    public List<Etiqueta> listar() {
        return repository.findAll();
    }

    public Etiqueta guardar(Etiqueta etiqueta) {
        return repository.save(etiqueta);
    }
}
