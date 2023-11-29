-- USUARIOS
SELECT * FROM usuarios;
SELECT contrasena FROM usuarios WHERE nombre = 'Alquezar';

-- RESTAURANTES
SELECT * FROM restaurantes;
SELECT clave FROM restaurantes WHERE nombre = 'Bo Wok';
SELECT R.nombre, P.nombre, P.precio FROM restaurantes R inner join productos P on R.id_restaurante = P.id_restaurante;
-- RESTAURANTES POR CATEGORÍA Y NOTA
SELECT R.id_restaurante, R.nombre, R.imagen, AVG(nota) AS nota_media FROM
restaurantes R INNER JOIN restaurantes_categorias RC ON R.id_restaurante=RC.id_restaurante
INNER JOIN puntuaciones P ON R.id_restaurante=P.id_restaurante
WHERE RC.id_categoria = 3
GROUP BY R.id_restaurante
ORDER BY nota_media DESC;

-- PRODUCTOS
SELECT * FROM productos;
SELECT * FROM productos WHERE id_restaurante = 4;
SELECT P.nombre, P.imagen, P.precio, count(P.id_producto) AS cantidad FROM
	productos P INNER JOIN lineas_compra LC ON P.id_producto = LC.id_producto
	INNER JOIN compras C ON LC.id_compra = C.id_compra
WHERE C.id_usuario = 1 AND C.confirmada = 0
GROUP BY P.id_producto;

-- PUNTUACIONES
INSERT INTO tabla_puntuaciones (id_usuario, id_restaurante, nota) VALUES (1, 5, 4) ON DUPLICATE KEY UPDATE nota = VALUES(nota);

-- COMPRAS
SELECT * FROM compras;
SELECT id_compra FROM compras WHERE id_usuario = 1 AND confirmada = 0;
SELECT * FROM compras WHERE id_usuario = 1 AND confirmada = 1;
-- HISTORIAL COMPRAS
SELECT C.id_compra, C.fecha, sum(P.precio) as precio_total FROM
compras C inner join lineas_compra LC ON C.id_compra=LC.id_compra
INNER JOIN productos P ON LC.id_producto=P.id_producto
 WHERE C.id_usuario=1 AND C.confirmada=1
 GROUP BY C.id_compra;
 

-- LINEAS_COMPRA
SELECT LC.* FROM lineas_compra LC INNER JOIN compras C ON C.id_compra = LC.id_compra WHERE LC.id_compra = 3;
SELECT * FROM lineas_compra ORDER BY id_compra;

-- TOP RESTAURANTES CON MÁS VENTAS
SELECT R.nombre, R.imagen FROM
	restaurantes R INNER JOIN productos P ON R.id_restaurante = P.id_restaurante
    INNER JOIN lineas_compra LC ON P.id_producto = LC.id_producto
    INNER JOIN compras C ON LC.id_compra = C.id_compra
WHERE C.confirmada = 1
GROUP BY R.id_restaurante
ORDER BY count(R.id_restaurante) DESC;

-- TOP RESTAURANTES MÁS PUNTUADOS
SELECT R.nombre, R.imagen, ROUND(AVG(P.nota), 1) AS nota_media FROM
	restaurantes R INNER JOIN puntuaciones P on R.id_restaurante = P.id_restaurante
GROUP BY R.id_restaurante
ORDER BY AVG(P.nota) DESC;

-- RESTAURANTES DE UNA CATEGORÍA
SELECT R.nombre, C.categoria FROM
restaurantes R INNER JOIN restaurantes_categorias RC ON R.id_restaurante = RC.id_restaurante
INNER JOIN categorias C ON RC.id_categoria = C.id_categoria
WHERE RC.id_categoria = 6;