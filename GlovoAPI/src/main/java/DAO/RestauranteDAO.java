package DAO;

import Model.MotorSQL;
import Model.Producto;
import Model.Restaurante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestauranteDAO {
    /////////////////////////////////////////ATRIBUTOS/////////////////////////////////////////
    private MotorSQL motorSql;

    /////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////
    public RestauranteDAO() {
        this.motorSql = new MotorSQL();
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public ArrayList<Restaurante> findAll(){
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT * FROM restaurantes");

            while(rs.next()){Restaurante restaurante = new Restaurante(
                    rs.getInt("id_restaurante"),
                    rs.getString("nombre"),
                    rs.getString("clave"),
                    rs.getString("descripcion"),
                    rs.getString("ubicacion"),
                    rs.getString("imagen")
            );
                listaRestaurantes.add(restaurante);
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(listaRestaurantes);
        return listaRestaurantes;
    }

    public ArrayList<Restaurante> findTopVentas(){
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT R.nombre, R.imagen FROM" +
                    " restaurantes R INNER JOIN productos P ON R.id_restaurante = P.id_restaurante" +
                    " INNER JOIN lineas_compra LC ON P.id_producto = LC.id_producto" +
                    " INNER JOIN compras C ON LC.id_compra = C.id_compra" +
                    " WHERE C.confirmada = 1" +
                    " GROUP BY R.id_restaurante" +
                    " ORDER BY sum(LC.cantidad) DESC;");

            while(rs.next()){Restaurante restaurante = new Restaurante(
                    rs.getString("nombre"),
                    rs.getString("imagen")
            );
                listaRestaurantes.add(restaurante);
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(listaRestaurantes);
        return listaRestaurantes;
    }

    public Restaurante findId(String nombre, String clave){
        Restaurante restaurante = new Restaurante();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT id_restaurante FROM restaurantes WHERE nombre = '"+nombre+"' AND clave = '"+clave+"'");

            while(rs.next()){
                restaurante.setId_restaurante(rs.getInt("id_restaurante"));
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(restaurante);
        return restaurante;
    }
}
