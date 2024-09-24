DROP TABLE IF EXISTS oficial;

CREATE TABLE oficial(
   id SERIAL PRIMARY KEY,
   usuario VARCHAR(45),
   contrasenia VARCHAR(255) 
);

INSERT INTO oficial
(id, usuario, contrasenia)
VALUES(1, 'admuser', '$2a$10$dJ/Sh4ypBASSSKudz9mu0Ok8gqDETLYqeX54SseVDSt50mtgqTE1y');

DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion TEXT,
    cedula VARCHAR(10)
);

INSERT INTO clientes (nombre, apellido, direccion, cedula) 
VALUES 
('Juan', 'Pérez', 'Calle Falsa 123, Quito', '1701234567'),
('María', 'López', 'Av. Amazonas 456, Quito', '1702345678'),
('Carlos', 'García', 'Calle de las Flores 789, Quito', '1703456789'),
('Ana', 'Ramírez', 'Calle Orellana 567, Quito', '1704567890'),
('Luis', 'Martínez', 'Av. Colón 654, Quito', '1705678901');


DROP TABLE IF EXISTS proveedores;
CREATE TABLE proveedores (
    id_proveedor SERIAL PRIMARY KEY,
    nombre_empresa VARCHAR(100)
);

INSERT INTO proveedores (nombre_empresa) 
VALUES ('Innovaciones Tecnológicas S.A.');


DROP TABLE IF EXISTS productos;
CREATE TABLE productos (
    id_producto SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    precio_unitario NUMERIC(10,2),
    id_proveedor INTEGER REFERENCES proveedores(id_proveedor),
    stock INTEGER
);

INSERT INTO productos (nombre, precio_unitario, id_proveedor, stock) 
VALUES 
('Auriculares Inalámbricos con Cancelación de Ruido', 199.99, 1, 50),
('Reloj Inteligente con Monitor de Salud', 249.50, 1, 35),
('Lámpara LED Inteligente con Control por Voz', 59.99, 1, 100),
('Cargador Solar Portátil para Dispositivos', 34.95, 1, 75),
('Teclado Ergonómico con Retroiluminación RGB', 89.99, 1, 40);




DROP TABLE IF EXISTS facturas;
CREATE TABLE facturas (
    id_factura SERIAL PRIMARY KEY,
    fecha_emision DATE,
    id_cliente INTEGER REFERENCES clientes(id_cliente),
    subtotal NUMERIC(10,2),
    iva NUMERIC(10,2),
    total NUMERIC(10,2)
);

-- Eliminar la tabla si existe y crearla nuevamente
DROP TABLE IF EXISTS detalle_factura;
CREATE TABLE detalle_factura (
    id_detalle SERIAL PRIMARY KEY,
    id_factura INTEGER REFERENCES facturas(id_factura),
    id_producto INTEGER REFERENCES productos(id_producto),
    cantidad INTEGER
);