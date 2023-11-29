package DAO;

import Model.Categoria;
import Model.MotorSQL;
import Model.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {
    /////////////////////////////////////////ATRIBUTOS/////////////////////////////////////////
    private MotorSQL motorSql;

    /////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////
    public CategoriaDAO() {
        this.motorSql = new MotorSQL();
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public ArrayList<Categoria> findAll(){
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT id_categoria, categoria FROM categorias ORDER BY categoria");

            while(rs.next()){Categoria categoria = new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("categoria")
            );
                listaCategorias.add(categoria);
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(listaCategorias);
        return listaCategorias;

    }
}
