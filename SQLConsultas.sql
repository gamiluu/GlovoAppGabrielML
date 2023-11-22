-- USUARIOS
SELECT * FROM usuarios;
SELECT contrasena FROM usuarios WHERE nombre = 'Alquezar';

-- RESTAURANTES
SELECT * FROM restaurantes;
SELECT clave FROM restaurantes WHERE nombre = 'Bo Wok';
SELECT R.nombre, P.nombre, P.precio FROM restaurantes R inner join productos P on R.id_restaurante = P.id_restaurante;

-- PRODUCTOS
SELECT * FROM productos;
SELECT * FROM productos WHERE id_restaurante = 4;

-- COMPRAS
SELECT * FROM compras;

-- LINEAS_COMPRA
SELECT LC.* FROM lineas_compra LC INNER JOIN compras C ON C.id_compra = LC.id_compra WHERE LC.id_compra = 3;
SELECT * FROM lineas_compra ORDER BY id_compra;

-- TOP RESTAURANTES CON MÁS VENTAS
SELECT R.nombre FROM
	restaurantes R INNER JOIN productos P ON R.id_restaurante = P.id_restaurante
    INNER JOIN lineas_compra LC ON P.id_producto = LC.id_producto
    INNER JOIN compras C ON LC.id_compra = C.id_compra
WHERE C.confirmada = 1
GROUP BY R.id_restaurante
ORDER BY sum(LC.cantidad) DESC;