-- Inserción USUARIOS
INSERT INTO usuarios (nombre, contrasena) VALUES ('Charly', 'charly');
INSERT INTO usuarios (nombre, contrasena) VALUES ('Gamiluu', 'gamiluu');
INSERT INTO usuarios (nombre, contrasena) VALUES ('Alquezar', 'alquezar');
SELECT * FROM usuarios;

-- Inserción RESTAURANTES
INSERT INTO restaurantes (nombre, clave, descripcion, ubicacion) VALUES ('Bo Wok', 'bowok', 'Restaurante chino cerca de Mamanucca', 'Calle Mamanucca 17, Zaragoza');
INSERT INTO restaurantes (nombre, clave, descripcion, ubicacion) VALUES ('Cafe Tudela', 'cafetudela', '¡Prueba la Hamburguesa del Chef! Aqui nadie se queda con hambre.', 'Plaza de la Constitución, Tudela');
INSERT INTO restaurantes (nombre, clave, descripcion, ubicacion) VALUES ('Pako Burger', 'pakoburger', 'La mejor calidad precio en hamburguesas.', 'Calle Alfonso 32, Zaragoza');
INSERT INTO restaurantes (nombre, clave, descripcion, ubicacion) VALUES ('La Zarzamora', 'lazarzamora', 'Muy rica comida, elaborada en el momento y una atención excelente. Muy buena ubicación en una localidad sorprendente.', 'Pl. Goicoerrotea 1, Tarazona');
INSERT INTO restaurantes (nombre, clave, descripcion, ubicacion) VALUES ('Sixty', 'sixty', '¡Las mejores cervezas de la Ribera Navarra!', 'Calle Plaza de Toros 69, Tudela');
SELECT * FROM restaurantes;
SELECT R.nombre, P.nombre, P.precio FROM restaurantes R inner join productos P on R.id_restaurante = P.id_restaurante;

-- Inserción PRODUCTOS
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (3, 'Pizza Hawaiana', '', 'Deliciosa pizza con piña y jamón', 15);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (1, 'Hamburguesa Deluxe', '', 'Jugosa hamburguesa con queso, bacon y salsa especial', 12);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (4, 'Ensalada Mediterránea', '', 'Ensalada fresca con tomate, aceitunas, queso feta y aderezo de hierbas', 9);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (2, 'Sushi Fusion', '', 'Variedad de sushi con ingredientes fusionados', 18);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (5, 'Pasta Carbonara', '', 'Pasta con salsa cremosa de huevo, queso, panceta y pimienta', 14);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (3, 'Pasta Bolognesa', '', 'Pasta con salsa de carne y tomate', 12);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (1, 'Enchiladas de Pollo', '', 'Tortillas rellenas de pollo y salsa de tomate', 10);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (4, 'Sopa de Verduras', '', 'Sopa caliente con una variedad de verduras frescas', 8);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (2, 'Tacos de Pescado', '', 'Tacos con filete de pescado, repollo y salsa de crema', 14);
INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES (5, 'Pollo a la Parrilla', '', 'Pechuga de pollo a la parrilla con hierbas y especias', 16);
SELECT * FROM productos;

-- Inserción COMPRAS
INSERT INTO compras (id_usuario, confirmada, fecha) VALUES(1,1,NOW());
INSERT INTO compras (id_usuario, confirmada, fecha) VALUES(2,1,NOW());
INSERT INTO compras (id_usuario, confirmada, fecha) VALUES(3,1,NOW());
INSERT INTO compras (id_usuario, confirmada, fecha) VALUES(1,0,NOW());
INSERT INTO compras (id_usuario, confirmada, fecha) VALUES(2,0,NOW());
INSERT INTO compras (id_usuario, confirmada, fecha) VALUES(3,0,NOW());
SELECT * FROM compras WHERE id_usuario = 2;

-- Inserción LINEAS_COMPRA
INSERT INTO lineas_compra (id_compra, id_producto) VALUES (13, 8);
SELECT * FROM lineas_compra ORDER BY id_compra;
DELETE FROM lineas_compra WHERE id_compra = 8;

-- Inserciones PUNTUACIONES
SELECT * FROM puntuaciones WHERE id_usuario = 2 ORDER BY id_usuario, id_restaurante;

-- Inserciones CATEGORÍAS
INSERT INTO categorias (categoria) VALUES
('Chino'),
('Hamburguesería'),
('Menu del día'),
('Bar'),
('Taberna'),
('Cervecería');
SELECT * FROM categorias; 

-- Inserciones RESTAURANTES_CATEGORÍAS
INSERT INTO restaurantes_categorias VALUES(1,1);
INSERT INTO restaurantes_categorias VALUES(2,2);
INSERT INTO restaurantes_categorias VALUES(2,3);
INSERT INTO restaurantes_categorias VALUES(2,4);
INSERT INTO restaurantes_categorias VALUES(3,2);
INSERT INTO restaurantes_categorias VALUES(4,3);
INSERT INTO restaurantes_categorias VALUES(4,4);
INSERT INTO restaurantes_categorias VALUES(5,4);
INSERT INTO restaurantes_categorias VALUES(5,5);
INSERT INTO restaurantes_categorias VALUES(5,6);
UPDATE restaurantes_categorias SET id_categoria=0 WHERE id_restaurante=0;
SELECT * FROM restfaurantes_categorias;
