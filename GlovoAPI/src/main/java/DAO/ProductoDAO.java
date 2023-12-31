package DAO;

import Model.MotorSQL;
import Model.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {
    /////////////////////////////////////////ATRIBUTOS/////////////////////////////////////////
    private MotorSQL motorSql;

    /////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////
    public ProductoDAO() {
        this.motorSql = new MotorSQL();
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public ArrayList<Producto> findAll(){
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT * FROM productos");

            while(rs.next()){Producto producto = new Producto(
                    rs.getInt("id_producto"),
                    rs.getInt("id_restaurante"),
                    rs.getString("nombre"),
                    rs.getString("imagen"),
                    rs.getString("descripcion"),
                    rs.getInt("precio")
            );
                listaProductos.add(producto);
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(listaProductos);
        return listaProductos;

    }
    public ArrayList<Producto> findById(String id_restaurante){
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT id_producto, nombre, imagen, descripcion, precio FROM productos WHERE id_restaurante = "+id_restaurante);

            while(rs.next()){Producto producto = new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getString("imagen"),
                    rs.getString("descripcion"),
                    rs.getInt("precio")
            );
                listaProductos.add(producto);
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(listaProductos);
        return listaProductos;
    }
    public int addProducto(String id_restaurante, String nombre, String imagen, String descripcion, String precio){
        int respuesta = 0;
        try{
            motorSql.conectar();
            String sql = "INSERT INTO productos (id_restaurante, nombre, imagen, descripcion, precio) VALUES('"
                    + id_restaurante + "', '"
                    + nombre + "', '"
                    + imagen + "', '"
                    + descripcion + "', '"
                    + precio + "')";
            System.out.println("Sentencia ->" + sql);
            respuesta = motorSql.modificar(sql);
        } finally {
            motorSql.desconectar();
        }
        System.out.println("Han sido modificadas " + respuesta + " lineas.");
        return respuesta;
    }
    public ArrayList<Producto> findCurrentCart(String id_usuario){
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT P.nombre, P.imagen, P.precio, count(P.id_producto) AS cantidad FROM "
                    + "productos P INNER JOIN lineas_compra LC ON P.id_producto = LC.id_producto "
                    + "INNER JOIN compras C ON LC.id_compra = C.id_compra "
                    + "WHERE C.id_usuario = "+id_usuario+" AND C.confirmada = 0 "
                    + "GROUP BY P.id_producto");

            while(rs.next()){Producto producto = new Producto(
                    rs.getString("nombre"),
                    rs.getString("imagen"),
                    rs.getInt("precio"),
                    rs.getInt("cantidad")
            );
                listaProductos.add(producto);
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(listaProductos);
        return listaProductos;
    }
}
