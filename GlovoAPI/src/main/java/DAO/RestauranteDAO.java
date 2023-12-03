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

    public ArrayList<Restaurante> findByCategoria(String id_categoria, String rate_order){
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT R.id_restaurante, R.nombre, R.imagen, AVG(nota) AS nota_media FROM " +
                    "restaurantes R INNER JOIN restaurantes_categorias RC ON R.id_restaurante=RC.id_restaurante " +
                    "INNER JOIN puntuaciones P ON R.id_restaurante=P.id_restaurante " +
                    "WHERE RC.id_categoria = "+id_categoria+" " +
                    "GROUP BY R.id_restaurante " +
                    "ORDER BY nota_media "+rate_order);

            while(rs.next()){Restaurante restaurante = new Restaurante(
                    rs.getInt("id_restaurante"),
                    rs.getString("nombre"),
                    rs.getString("imagen"),
                    rs.getDouble("nota_media")
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

    public Restaurante findRestaurante(String id_restaurante){
        Restaurante restaurante = new Restaurante();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT nombre, descripcion, ubicacion, imagen FROM restaurantes WHERE id_restaurante = "+id_restaurante);

            while(rs.next()){
                restaurante.setNombre(rs.getString("nombre"));
                restaurante.setDescripcion(rs.getString("descripcion"));
                restaurante.setUbicacion(rs.getString("ubicacion"));
                restaurante.setImagen(rs.getString("imagen"));

            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(restaurante);
        return restaurante;
    }

    public ArrayList<Restaurante> findTopVentas(){
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
        try{
            motorSql.conectar();
            String sql = "SELECT R.id_restaurante, R.nombre, R.imagen FROM" +
                    " restaurantes R INNER JOIN productos P ON R.id_restaurante = P.id_restaurante" +
                    " INNER JOIN lineas_compra LC ON P.id_producto = LC.id_producto" +
                    " INNER JOIN compras C ON LC.id_compra = C.id_compra" +
                    " WHERE C.confirmada = 1" +
                    " GROUP BY R.id_restaurante" +
                    " ORDER BY count(R.id_restaurante) DESC";
            System.out.println(sql);
            ResultSet rs = motorSql.consultar(sql);

            while(rs.next()){Restaurante restaurante = new Restaurante(
                    rs.getInt("id_restaurante"),
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

    public ArrayList<Restaurante> findTopRating(){
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT R.id_restaurante, R.nombre, R.imagen, ROUND(AVG(P.nota),1) AS nota_media FROM" +
                    " restaurantes R INNER JOIN puntuaciones P on R.id_restaurante = P.id_restaurante" +
                    " GROUP BY R.id_restaurante" +
                    " ORDER BY AVG(P.nota) DESC");

            while(rs.next()){Restaurante restaurante = new Restaurante(
                    rs.getInt("id_restaurante"),
                    rs.getString("nombre"),
                    rs.getString("imagen"),
                    rs.getDouble("nota_media")
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
