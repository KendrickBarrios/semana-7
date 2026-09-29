CREATE TABLE proveedor (
                          id SERIAL PRIMARY KEY,
                          nombre VARCHAR(150) NOT NULL,
                          telefono VARCHAR(8) NOT NULL,
                          correo VARCHAR(50) NOT NULL,
                          precio_venta NUMERIC(12,2) NOT NULL,
                          existencia INTEGER NOT NULL DEFAULT 0,
                          categoria_id INTEGER NOT NULL,
                          activa BOOLEAN NOT NULL DEFAULT TRUE
);

ALTER TABLE producto
ADD COLUMN proveedor_id;

ALTER TABLE producto
ADD CONSTRAINT fk_producto_proveedor
FOREIGN KEY (proveedor_id)
REFERENCES proveedor(id);