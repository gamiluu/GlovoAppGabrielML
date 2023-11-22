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
        System.out.println("Han sido modificadas" + respuesta + " lineas.");
        return respuesta;
    }
}
