package ni.edu.uam.gestion_productos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String telefono;

    private String correo;

    private Boolean activo;
}
